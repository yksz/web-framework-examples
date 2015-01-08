package bbs

class Board {

    String name
    String description

    static hasMany = [threads: Thread]

    static mapping = {
        threads fetch: 'join', sort: 'id'
    }

    static constraints = {
        name maxSize: 32, unique: true, blank: false
    }
}
