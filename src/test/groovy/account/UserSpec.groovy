package account

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

@Integration
@Rollback
class UserSpec extends Specification implements DomainUnitTest<User> {

    void setup() {
        new User(userAccount: 'jdoe', userFullname:'John Doe').save(flush: true)
    }

    def cleanup() {
    }

    void "test - check user"() {
        given:

        expect:
            User.count() == 1
    }

    void "test - add user"() {
        given:
            new User(userAccount: 'jdoe', userFullname:'John Doe').save(flush: true)

        expect:
            User.count() == 2
    }


}
