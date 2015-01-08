package bbs

class LinesTagLib {

    def lines = { attrs, body ->
        out << attrs['string'].encodeAsHTML().replace('\n', '<br/>\n')
    }

}
