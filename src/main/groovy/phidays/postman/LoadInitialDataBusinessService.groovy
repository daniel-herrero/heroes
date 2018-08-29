package phidays.postman

import grails.gorm.transactions.Transactional
import phidays.postman.business.AbilityBusinessService
import phidays.postman.business.CharacterBusinessService
import phidays.postman.Ability.Level

@Transactional
class LoadInitialDataBusinessService {
    AbilityBusinessService abilityBusinessService
    CharacterBusinessService characterBusinessService

    private final String ABILITY_DESC = "This fictional hero has extraordinary powers to use in his fight against " +
        "crime and evil. "

    def loadAbilities() {
        Map<String, Ability> abilityMap = [:]
        Ability.Level.values().each() { level ->
            createAbility("Superhuman Strength", ABILITY_DESC, level)
            createAbility("Flight", ABILITY_DESC, level)
            createAbility("Early Warning level", ABILITY_DESC, level)
        }
    }

    def loadHeroes() {
        loadAbilities()

        List<Ability> supermanAbilities = [
            Ability.findByNameAndLevel("Superhuman Strength", Level.EXCELLENT),
            Ability.findByNameAndLevel("Flight", Ability.Level.INCREDIBLE)
        ]
        List<Ability> spidermanAbilities = [
            Ability.findByNameAndLevel("Superhuman Strength", Level.TYPICAL),
            Ability.findByNameAndLevel("Flight", Ability.Level.EXCELLENT)
        ]

        createCharacter("Clark Kent", "Superman", supermanAbilities)
        createCharacter("Peter Parker", "Spiderman", spidermanAbilities)
    }

    private void createCharacter(String fullName, String alterEgo, List<Ability> heroAbilities) {
        Character hero = Character.builder()
            .fullName(fullName)
            .alterEgo(alterEgo)
            .build()

        characterBusinessService.create(hero, heroAbilities)
    }

    private Ability createAbility(String name, String desc, Level level) {
        Ability ability = Ability.builder()
            .name(name)
            .description(desc)
            .level(level)
            .build()

        return abilityBusinessService.create(ability)
    }
}
