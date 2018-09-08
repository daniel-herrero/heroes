package phidays.heroes.character

import groovy.transform.builder.Builder
import phidays.heroes.ability.Ability

@Builder
class Character {
    String fullName
    String alterEgo

    static hasMany = [ abilities: Ability ]

    static constraints = {
        alterEgo maxSize: 255
        fullName maxSize: 255, nullable: true
    }

    static mapping = {
        id generator: 'increment'
    }
}
