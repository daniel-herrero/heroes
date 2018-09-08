package phidays.heroes.domain

import grails.testing.gorm.DomainUnitTest
import phidays.heroes.character.Character
import spock.lang.Specification

class CharacterSpec extends Specification implements DomainUnitTest<Character> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
