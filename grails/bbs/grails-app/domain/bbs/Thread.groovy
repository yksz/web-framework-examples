package bbs

class Thread {

    String title
    Date dateCreated
    int responseCount

    static belongsTo = [board: Board]
    static hasMany = [responses: Response]

    static mapping = {
        responses fetch: 'join', sort: 'id'
    }

    static constraints = {
        title maxSize: 64, blank: false
        dateCreated nullable: true
    }
}
