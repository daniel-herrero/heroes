package phidays.heroes.business

import grails.gorm.transactions.Transactional
import phidays.heroes.ability.Ability
import phidays.heroes.repository.AbilityRepositoryService

@Transactional
class AbilityBusinessService {
    AbilityRepositoryService abilityRepositoryService

    def createOrUpdate(Ability ability) {
        abilityRepositoryService.save(ability)

        return ability
    }

    List<Ability> list() {
        return abilityRepositoryService.listAbilities()
    }

    List<Ability> findAbilitiesByIds(List<Integer> abilityIds) {
        List<Ability> abilityList = []
        abilityIds.each {
            Ability ability = findById(it)
            if (ability) {
                abilityList.add(ability)
            }
        }

        return abilityList
    }

    Ability findById(Long abilityId) {
        return abilityRepositoryService.findById(abilityId)
    }
}
