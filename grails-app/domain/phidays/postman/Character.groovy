package phidays.postman

import groovy.transform.builder.Builder

@Builder
class Character {
    String fullName
    String alterEgo

    static hasMany = [ abilities: Ability ]

    static constraints = {
        alterEgo maxSize: 255
        fullName maxSize: 255, nullable: true
    }
}
