package phidays.heroes.command

import phidays.heroes.ApiCommand
import phidays.heroes.ability.Ability.Level

class UpdateCharacterCommand implements ApiCommand {
    String fullName
    String alterEgo
    List<Integer> abilities

    static constraints = {
        alterEgo nullable: true
        fullName nullable: true
        abilities nullable: true
    }
}

