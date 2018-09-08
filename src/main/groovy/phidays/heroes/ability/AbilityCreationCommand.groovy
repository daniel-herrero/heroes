package phidays.heroes.ability

import phidays.heroes.ability.Ability.Level
import phidays.heroes.ApiCommand

class AbilityCreationCommand implements ApiCommand {
    String name
    String description
    Level level

    static constraints = {
        name nullable: false
        description nullable: true
        level nullable: true, inList: Level.values().toList()
    }
}
