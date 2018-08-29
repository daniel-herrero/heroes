package phidays.postman

import grails.converters.JSON
import phidays.postman.command.ability.AbilityCreationCommand
import phidays.postman.business.AbilityBusinessService

class AbilityController {
    AbilityBusinessService abilityBusinessService

    def createAbility(AbilityCreationCommand cmd) {
        Ability ability = Ability.builder()
            .name(cmd.name)
            .description(cmd.description)
            .level(cmd.level)
            .build()
        abilityBusinessService.create(ability)

        render ability as JSON
    }

    def listAbilities() {
        render abilityBusinessService.list() as JSON
    }
}
