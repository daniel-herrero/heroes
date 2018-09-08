package phidays.heroes.ability

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
        POOR(0),
        TYPICAL(1),
        GOOD(2),
        EXCELLENT(3),
        INCREDIBLE(4),
        AMAZING(5)

        private final int powerLevel
        Level(int powerLevel) { this.powerLevel = powerLevel }
    }
}
