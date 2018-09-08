package phidays.heroes.business

import grails.gorm.transactions.Transactional
import phidays.heroes.ability.Ability
import phidays.heroes.character.Character
import phidays.heroes.repository.CharacterRepositoryService

@Transactional
class CharacterBusinessService {
    CharacterRepositoryService characterRepositoryService

    Character createOrUpdate(Character character, List<Ability> abilityList = null) {
        character.abilities = abilityList
        characterRepositoryService.save(character)

        return character
    }

    List<Character> list() {
        return characterRepositoryService.list()
    }

    Character findById(Long characterId) {
        return characterRepositoryService.findById(characterId)
    }

    Boolean delete(Character character) {
        return characterRepositoryService.delete(character)
    }
}
