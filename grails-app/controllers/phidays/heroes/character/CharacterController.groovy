package phidays.heroes.character

import grails.converters.JSON
import grails.validation.ValidationException
import javassist.NotFoundException
import phidays.heroes.ability.Ability
import phidays.heroes.business.AbilityBusinessService
import phidays.heroes.business.CharacterBusinessService
import phidays.heroes.command.CharacterCreationCommand
import phidays.heroes.command.DeleteCharacterCommand
import phidays.heroes.command.UpdateCharacterCommand

class CharacterController {

    CharacterBusinessService characterBusinessService
    AbilityBusinessService abilityBusinessService

    def listCharacters() {
        render characterBusinessService.list() as JSON
    }

    def createCharacter(CharacterCreationCommand cmd) {
        Character character = Character.builder()
            .fullName(cmd.fullName)
            .alterEgo(cmd.alterEgo)
            .build()

        List<Ability> abilitiesList = abilityBusinessService.findAbilitiesByIds(cmd.abilities)
        characterBusinessService.createOrUpdate(character, abilitiesList)

        response.status = 201
        render character as JSON
    }

    def updateCharacter(UpdateCharacterCommand cmd, Long characterId) {
        Character character = checkAndReturnCharacter(characterId)
        List<Ability> abilityList = checkAndReturnAbilities(cmd.abilities)

        character.properties = cmd
        characterBusinessService.createOrUpdate(character, abilityList)

        response.status = 202
        render character as JSON
    }

    def deleteCharacter(DeleteCharacterCommand cmd) {
        Character character = checkAndReturnCharacter(cmd.characterId)
        characterBusinessService.delete(character)

        response.status = 204
        render [:] as JSON
    }

    private void stopAndReturn404() {
        throw new NotFoundException("")
        render [:] as JSON
    }

    private void checkForIdParameter(Long id) {
        if ( !id instanceof Long || id == null) {
            throw new ValidationException("", this.errors)
        }
    }

    private List<Ability> checkAndReturnAbilities(List abilities) {
        List<Ability> abilityList = []
        abilities.each { abilityId ->
            Ability ability = abilityBusinessService.findById(abilityId)
            if (!ability) {
                stopAndReturn404()
            }
            abilityList.add(ability)
        }

        return abilityList
    }

    private Character checkAndReturnCharacter(Long characterId) {
        checkForIdParameter(characterId)
        Character character = characterBusinessService.findById(characterId)
        if (!character) {
            stopAndReturn404()
        }

        return character
    }

}
