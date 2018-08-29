package phidays.postman.repository

import phidays.postman.Character

class CharacterRepositoryService {

    Character save(Character character) {
        character.save(flush: true)

        return character
    }

    List<Character> list() {
        return Character.list()
    }


    Character findById(Integer characterId) {
        return Character.get(characterId)
    }
}
