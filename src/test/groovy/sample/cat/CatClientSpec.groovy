package sample.cat

import com.stehno.ersatz.ErsatzServer
import grails.testing.mixin.integration.Integration
import org.grails.testing.GrailsUnitTest
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.AutoCleanup
import spock.lang.Specification

import static org.hamcrest.Matchers.startsWith

@Integration
class CatClientSpec extends Specification implements GrailsUnitTest {
    @AutoCleanup
    ErsatzServer ersatz

    @Autowired
    CatClient catClient

    def setup() {
        ersatz = new ErsatzServer()
        ersatz.start()
        // FIXME: how do I set up the URL?
//        service.catUrl = ersatz.httpUrl + '/'
        // FIXME: this doesn't work
        System.setProperty('cat-service.url', ersatz.httpUrl)
    }

    def cleanup() {
        ersatz.verify()
    }

    def "Search"() {
        given:
        def jsonData = '''
[{"breeds":[],"id":"ceb","url":"https://cdn2.thecatapi.com/images/ceb.gif","width":200,"height":151}]
'''
        ersatz.expectations {
            get(startsWith('/images/search')) {
                called 1
                responder {
                    body jsonData, 'application/json;chartset=UTF-8'
                }
            }
        }

        when:
        def results = catClient.search()

        then:
        results != null
        results.size() == 1
    }
}
