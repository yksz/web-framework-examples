package pages

import geb.Page
import util.Message

class IndexPage extends Page {

    static url = "http://localhost:8080/bbs/"
    static at = { title == Message.get('bbs.index.page.title') }
    static content = {
        menu { $("frame", name: "menuFrame") }
        main { $("frame", name: "mainFrame") }
    }

}
