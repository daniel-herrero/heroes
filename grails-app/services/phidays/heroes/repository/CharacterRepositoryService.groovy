package phidays.heroes.repository

import phidays.heroes.character.Character

class CharacterRepositoryService {

    Character save(Character character) {
        character.save()

        return character
    }

    Character delete(Character character) {
        println "===> Character to delete: ${character}"
        character.delete()

        return character
    }

    List<Character> list() {
        return Character.list().sort{it.id}
    }


    Character findById(Long characterId) {
        return Character.get(characterId)
    }
}
