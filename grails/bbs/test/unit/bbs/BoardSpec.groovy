package bbs

import spock.lang.Unroll

class BoardSpec extends ConstraintsUnitSpec {

    def setup() {
        def existingBoard = new Board(name: 'unique_name', description: 'description')
        mockForConstraintsTests(Board, [existingBoard])
    }

    @Unroll
    def "constraints: if #field is #val, then #error"() {
        when:
        def obj = new Board("$field": val)

        then:
        validate(obj, field, error)

        where:
        error      | field         | val
        'nullable' | 'name'        | null
        'blank'    | 'name'        | ''
        'valid'    | 'name'        | newString(32)
        'maxSize'  | 'name'        | newString(33)
        'unique'   | 'name'        | 'unique_name'
        'nullable' | 'description' | null
        'valid'    | 'description' | ''
    }
}
