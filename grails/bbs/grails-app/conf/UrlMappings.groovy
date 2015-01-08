class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')

        "/main"(view:"/main")
        "/menu"(view:"/menu")

        "/$board_id"(controller: "board", action: "index") {
            constraints {
                board_id matches: "\\d+"
            }
        }
        "/$board_id/add"(controller: "board", action: "addThread") {
            constraints {
                board_id matches: "\\d+"
            }
        }
        "/$board_id/$thread_id"(controller: "thread", action: "index") {
            constraints {
                board_id matches: "\\d+"
                thread_id matches: "\\d+"
            }
        }
        "/$board_id/$thread_id/add"(controller: "thread", action: "addResponse") {
            constraints {
                board_id matches: "\\d+"
                thread_id matches: "\\d+"
            }
        }
    }
}
