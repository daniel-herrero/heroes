package phidays.postman.business

import grails.gorm.transactions.Transactional
import phidays.postman.Ability
import phidays.postman.repository.AbilityRepositoryService

@Transactional
class AbilityBusinessService {
    AbilityRepositoryService abilityRepositoryService

    def create(Ability ability) {
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

    Ability findById(Integer abilityId) {
        return abilityRepositoryService.findById(abilityId)
    }
}
