package phidays.heroes

import grails.gorm.transactions.Transactional
import phidays.heroes.character.Character
import phidays.heroes.ability.Ability
import phidays.heroes.business.AbilityBusinessService
import phidays.heroes.business.CharacterBusinessService
import phidays.heroes.ability.Ability.Level

@Transactional
class LoadInitialDataBusinessService {
    AbilityBusinessService abilityBusinessService
    CharacterBusinessService characterBusinessService

    private final String ABILITY_DESC = "This fictional hero has extraordinary powers to use in his fight against " +
        "crime and evil. "

    def loadAbilities() {
        Ability.Level.values().each() { level ->
            createAbility("Superhuman Strength", ABILITY_DESC, level)
            createAbility("Flight", ABILITY_DESC, level)
            createAbility("Early Warning", ABILITY_DESC, level)
        }
    }

    def loadHeroes() {
        loadAbilities()

        List<Ability> supermanAbilities = [
            Ability.findByNameAndLevel("Superhuman Strength", Level.INCREDIBLE),
            Ability.findByNameAndLevel("Flight", Ability.Level.AMAZING)
        ]
        List<Ability> spidermanAbilities = [
            Ability.findByNameAndLevel("Superhuman Strength", Level.TYPICAL),
            Ability.findByNameAndLevel("Early Warning", Ability.Level.EXCELLENT)
        ]

        createCharacter("Clark Kent", "Superman", supermanAbilities)
        createCharacter("Peter Parker", "Spiderman", spidermanAbilities)
    }

    private void createCharacter(String fullName, String alterEgo, List<Ability> heroAbilities) {
        Character hero = Character.builder()
            .fullName(fullName)
            .alterEgo(alterEgo)
            .build()

        characterBusinessService.createOrUpdate(hero, heroAbilities)
    }

    private Ability createAbility(String name, String desc, Level level) {
        Ability ability = Ability.builder()
            .name(name)
            .description(desc)
            .level(level)
            .build()

        return abilityBusinessService.createOrUpdate(ability)
    }
}
