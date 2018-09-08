package phidays.heroes.ability

import phidays.heroes.ability.Ability.Level
import phidays.heroes.ApiCommand

class UpdateAbilityCommand implements ApiCommand {
    String name
    String description
    Level level

    static constraints = {
        name nullable: true, blank: true
        description nullable: true, blank: true
        level nullable: true, inList: Level.values().toList()
    }
}

