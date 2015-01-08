package bbs

import spock.lang.Unroll

class ThreadSpec extends ConstraintsUnitSpec {

    def setup() {
        mockForConstraintsTests(Thread)
    }

    @Unroll
    def "constraints: if #field is #val, then #error"() {
        when:
        def obj = new Thread("$field": val)

        then:
        validate(obj, field, error)

        where:
        error      | field         | val
        'nullable' | 'title'       | null
        'blank'    | 'title'       | ''
        'valid'    | 'title'       | newString(64)
        'maxSize'  | 'title'       | newString(65)
        'valid'    | 'dateCreated' | null
    }
}
