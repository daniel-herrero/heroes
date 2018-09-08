package phidays.heroes.marshaller

import grails.converters.JSON
import phidays.heroes.ability.Ability
import phidays.heroes.character.Character

class JSONMarshallers {

    static init() {
        JSON.registerObjectMarshaller(Ability, abilityMarshaller)
        JSON.registerObjectMarshaller(Ability.Level, abilityLevelMarshaller)
        JSON.registerObjectMarshaller(Character, characterMarshaller)
    }

    static abilityMarshaller = { Ability ability ->
        return [
            id: ability.id,
            name: ability.name,
            level: ability.level,
            description: ability.description
        ]
    }

    static abilityLevelMarshaller = { Ability.Level abilityLevel ->
        return [
            power: "${abilityLevel.powerLevel}/5",
            name: abilityLevel.name()
        ]
    }

    static characterMarshaller = { Character character ->
        return [
            id: character.id,
            fullName: character.fullName,
            alterEgo: character.alterEgo,
            abilities: character.abilities.sort{it.id}
        ]
    }
}
