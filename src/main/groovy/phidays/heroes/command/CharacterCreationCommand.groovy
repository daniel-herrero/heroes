package phidays.heroes.command

import phidays.heroes.ApiCommand

class CharacterCreationCommand implements ApiCommand {
    String fullName
    String alterEgo
    List<Integer> abilities

    static constraints = {
        fullName nullable: true
        abilities nullable: true
    }
}
