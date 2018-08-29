package phidays.postman.command.ability

import phidays.postman.command.ApiCommand

class CharacterCreationCommand implements ApiCommand {
    String fullName
    String alterEgo
    List<Integer> abilities

    static constraints = {
        fullName nullable: true
        abilities nullable: true
    }
}
