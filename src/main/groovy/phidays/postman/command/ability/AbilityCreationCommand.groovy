package phidays.postman.command.ability

import phidays.postman.Ability
import phidays.postman.command.ApiCommand

class AbilityCreationCommand implements ApiCommand {
    String name
    String description
    Ability.Level level

    static constraints = {
        name nullable: false
        description nullable: true
    }
}
