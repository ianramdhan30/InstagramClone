package cookode.instagram_clone.model

data class User (
    var username : String? = "",
    var fullname : String? = "",
    var bio : String? = "",
    var image : String? = null,
    var uid : String? = ""
)