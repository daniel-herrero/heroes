package phidays.postman.repository

import phidays.postman.Ability

class AbilityRepositoryService {

    Ability save(Ability ability) {
        ability.save(flush: true)

        return ability
    }

    List<Ability> listAbilities() {
        return Ability.createCriteria().list {
            and {
                order('name', 'desc')
                order('level', 'asc')
            }
        }
    }

    Ability findById(Integer abilityId) {
        return Ability.get(abilityId)
    }
}
