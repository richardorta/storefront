package account

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.*
import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

@Integration
@Rollback
class UserSpec extends Specification implements DomainUnitTest<User> {

    void setupData() {
        new User(userAccount: 'jdoe', userFullname:'John Doe').save(flush: true)
    }

    def cleanup() {
    }

    void "test - check user" () {
        given:
            setupData()
            //new User(userAccount: 'jdoe', userFullname:'John Doe').save(flush: true)

        expect:
            User.count() == 1
    }

    void "test - add user" () {
        given:
            new User(userAccount: 'jdoe', userFullname:'John Doe').save(flush: true)

        expect:
            User.count() == 1
    }

    void 'test for null' () {
        when:
            domain.userAccount = null

        then:
            !domain.validate(['userAccount'])
            domain.errors['userAccount'].code == 'nullable'
    }

    /*
    void 'test for blank' () {
        when:
            domain.userAccount = ''
        
        then:
            !domain.validate(['userAccount'])
    }
    */
    

}
