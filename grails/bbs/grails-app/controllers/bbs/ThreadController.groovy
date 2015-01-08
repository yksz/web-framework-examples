package bbs

class ThreadController {

    def index() {
        def thread = Thread.get(params.thread_id)
        render view: 'thread', model: [board: thread.board, thread: thread, responses: thread.responses]
    }

    def addResponse() {
        withForm {
            if (request.post) {
                def thread = Thread.get(params.thread_id)
                thread.responseCount += 1

                def res = new Response(number: thread.responseCount, message: params.message)
                if (params.username)
                    res.username = params.username

                thread.addToResponses(res)
                thread.save(flush: true, failOnError: true)
            }
        }.invalidToken {
        }
        redirect controller: 'thread', action: 'index', params: [board_id: params.board_id, thread_id: params.thread_id]
    }
}
