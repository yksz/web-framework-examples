package specs
import geb.spock.GebReportingSpec;
import pages.IndexPage
import util.Message

class IndexPageSpec extends GebReportingSpec {

    def "index page test"() {
        when:
        to IndexPage

        then:
        at IndexPage

        and:
        withFrame(main) {
            $("h1").text() == Message.get('bbs.main.title')
        }

        when:
        withFrame(menu) {
            $("a", 0).click()
        }

        then:
        withFrame(main) {
            waitFor {
                $("input", name: "submit").@value == Message.get('bbs.thread.create')
            }
        }
    }

}
