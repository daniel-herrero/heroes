package phidays.heroes.command

import phidays.heroes.ApiCommand

class DeleteCharacterCommand implements ApiCommand {
    Long characterId

    static constraints = {
        characterId nullable: false, min: 1L
    }
}

