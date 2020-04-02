package client.spec

import grails.testing.services.ServiceUnitTest
import sample.cat.CatClient
import spock.lang.Specification

class CatServiceSpec extends Specification implements ServiceUnitTest<CatService> {
    CatClient catClient = Mock()

    def setup() {
        service.catClient = catClient
    }

    void "search() -  should invoke the REST client"() {
        when:
        def result = service.search()

        then:
        1 * catClient.search() >> []
        result == []
    }
}
