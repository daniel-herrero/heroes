package phidays.postman

import grails.converters.JSON
import phidays.postman.business.AbilityBusinessService
import phidays.postman.business.CharacterBusinessService
import phidays.postman.command.ability.CharacterCreationCommand

class CharacterController {

    CharacterBusinessService characterBusinessService
    AbilityBusinessService abilityBusinessService

    def createCharacter(CharacterCreationCommand cmd) {
        Character character = Character.builder()
            .fullName(cmd.fullName)
            .alterEgo(cmd.alterEgo)
            .build()

        List<Ability> abilitiesList = abilityBusinessService.findAbilitiesByIds(cmd.abilities)
        characterBusinessService.create(character, abilitiesList)

        render character as JSON
    }

    def listCharacters() {
        render characterBusinessService.list() as JSON
    }

}
