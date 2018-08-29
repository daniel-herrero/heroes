package phidays.postman.business

import grails.gorm.transactions.Transactional
import phidays.postman.Ability
import phidays.postman.Character
import phidays.postman.repository.CharacterRepositoryService

@Transactional
class CharacterBusinessService {
    CharacterRepositoryService characterRepositoryService

    Character create(Character character, List<Ability> abilityList = null) {
        character.abilities = abilityList
        characterRepositoryService.save(character)

        return character
    }

    List<Character> list() {
        return characterRepositoryService.list()
    }

    Character findById(Integer characterId) {
        return characterRepositoryService.findById(characterId)
    }
}
