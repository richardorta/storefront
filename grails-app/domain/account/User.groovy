package account

class User {
    String userAccount
    String userFullname
    String email
    Date createdOn

    static constraints = {
        userAccount blank: false, maxSize: 32
    }
}
