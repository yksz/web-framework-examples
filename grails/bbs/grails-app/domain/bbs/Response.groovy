package bbs

class Response {

    int number
    String username = "Anonymous"
    Date dateCreated
    String pin = "???"
    String message

    static belongsTo = [thread: Thread]

    static constraints = {
        number max: 1001
        username maxSize: 16
        dateCreated nullable: true
        pin maxSize: 9
    }
}
