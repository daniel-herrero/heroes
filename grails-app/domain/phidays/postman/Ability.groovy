package phidays.postman

import groovy.transform.builder.Builder

@Builder
class Ability {
    String name
    String description
    Level level

    static constraints = {
        name maxSize: 255
        level enumType: 'string'
        description nullable: true
    }

    static mapping = {
        description type: 'text'
    }

    static enum Level {
        POOR(1),
        TYPICAL(2),
        GOOD(3),
        EXCELLENT(4),
        INCREDIBLE(5)

        private final int powerLevel
        Level(int powerLevel) { this.powerLevel = powerLevel }
    }
}
