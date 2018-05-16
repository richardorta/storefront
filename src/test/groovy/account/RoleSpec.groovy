package account

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class RoleSpec extends Specification implements DomainUnitTest<Role> {

    def setup() {
        new Role(roleName: 'Boss', description:'Top dog!').save(flush: true)
    }

    def cleanup() {
    }

    void "test - check role"() {
        given:

        expect:
            Role.count() == 1
    }

    void "test - add role"() {
        given:
            new Role(roleName: 'Minion', description:'Low on totem pole').save(flush: true)

        expect:
            Role.count() == 2
    }

}
