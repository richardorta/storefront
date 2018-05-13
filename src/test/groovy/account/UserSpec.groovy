package account

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class UserSpec extends Specification implements DomainUnitTest<User> {

    def setup() {
        new User(userAccount: 'jdoe').save(flush: true)
    }

    def cleanup() {
    }

    void 'test for null'() {
        when:
            domain.userAccount = null
        
        then:
            !domain.validate(['userAccount'])
            domain.errors['userAccount'].code == 'nullable'
    }

    void 'test for blank'() {
        when:
            domain.userAccount = ''
        then:
            !domain.validate(['userAccount'])
    }
    
}
