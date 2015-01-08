package bbs

import grails.plugin.spock.UnitSpec
import spock.lang.Specification

abstract class ConstraintsUnitSpec extends UnitSpec {

    void validate(obj, field, error) {
        assert error
        def validated = obj.validate()
        if (error == 'valid') {
            assert !obj.errors[field]
        } else {
            assert !validated
            assert obj.errors[field]
            assert error == obj.errors[field]
        }
    }

    String newString(int length) {
        def builder = new StringBuilder()
        for (i in 1 .. length)
            builder.append(i % 10)
        return builder.toString()
    }
}
