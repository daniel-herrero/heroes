package phidays.heroes.ability

import grails.converters.JSON
import grails.validation.ValidationException
import javassist.NotFoundException
import phidays.heroes.business.AbilityBusinessService

class AbilityController {
    AbilityBusinessService abilityBusinessService

    def createAbility(AbilityCreationCommand cmd) {
        Ability ability = Ability.builder()
            .name(cmd.name)
            .description(cmd.description)
            .level(cmd.level)
            .build()
        abilityBusinessService.createOrUpdate(ability)

        response.status = 201
        render ability as JSON
    }

    def listAbilities() {
        render abilityBusinessService.list() as JSON
    }

    def updateAbility(UpdateAbilityCommand cmd, Long abilityId) {
        checkForIdParameter(abilityId)

        Ability ability = abilityBusinessService.findById(abilityId)
        if (!ability) {
            stopAndReturn404()
        }

        ability.name = cmd.name ?: ability.name
        ability.description = cmd.description ?: ability.description
        ability.level = cmd.level ?: ability.level
        abilityBusinessService.createOrUpdate(ability)

        response.status = 202
        render ability as JSON
    }

    private void stopAndReturn404() {
        throw new NotFoundException("")
        render [:] as JSON
    }

    private void checkForIdParameter(Long id) {
        if ( !id instanceof Long || id == null) {
            throw new ValidationException("", this.errors)
        }
    }
}
