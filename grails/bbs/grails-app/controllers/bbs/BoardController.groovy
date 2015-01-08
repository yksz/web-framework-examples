package bbs

class BoardController {

    def index() {
        def board = Board.get(params.board_id)
        render view: 'board', model: [board: board, threads: board.threads]
    }

    def addThread() {
        withForm {
            if (request.post) {
                def res = new Response(number: 1, message: params.message)
                if (params.username)
                    res.username = params.username

                def thread = new Thread(title: params.title, responseCount: 1)
                thread.addToResponses(res)

                def board = Board.get(params.board_id)
                board.addToThreads(thread)
                board.save(flush: true, failOnError: true)
            }
        }.invalidToken {
        }
        redirect controller: 'board', action: 'index', params: [board_id: params.board_id]
    }
}
