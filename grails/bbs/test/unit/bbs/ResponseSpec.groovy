package bbs

import spock.lang.Unroll

class ResponseSpec extends ConstraintsUnitSpec {

    def setup() {
        mockForConstraintsTests(Response)
    }

    @Unroll
    def "constraints: if #field is #val, then #error"() {
        when:
        def obj = new Response("$field": val)

        then:
        validate(obj, field, error)

        where:
        error      | field         | val
        'valid'    | 'number'      | 1001
        'max'      | 'number'      | 1002
        'nullable' | 'username'    | null
        'valid'    | 'username'    | ''
        'valid'    | 'username'    | newString(16)
        'maxSize'  | 'username'    | newString(17)
        'valid'    | 'dateCreated' | null
        'nullable' | 'pin'         | null
        'valid'    | 'pin'         | ''
        'valid'    | 'pin'         | newString(9)
        'maxSize'  | 'pin'         | newString(10)
        'nullable' | 'message'     | null
        'valid'    | 'message'     | ''
    }
}
