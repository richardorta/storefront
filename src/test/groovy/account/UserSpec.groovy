package account

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
        new User(userAccount: 'jdoe').save(flush: true)
    }

    def cleanup() {
    }

    void "testCreateAccount"() {
//        given:
//            setup()

        expect:
            User.count() == 1
    }

//    void "test"() {
//        given:
//            setup()
//
//        expect:
//            userAccount == 'jdoe'
//    }

}
