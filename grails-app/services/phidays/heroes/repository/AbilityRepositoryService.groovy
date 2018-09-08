package phidays.heroes.repository

import phidays.heroes.ability.Ability

class AbilityRepositoryService {

    Ability save(Ability ability) {
        ability.save(flush: true)

        return ability
    }

    List<Ability> listAbilities() {
        return Ability.createCriteria().list {
            and {
                order('id', 'asc')
                order('name', 'asc')
            }
        }
    }

    Ability findById(Long abilityId) {
        return Ability.get(abilityId)
    }
}
