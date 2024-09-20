package sahak.sahakyan.github.data.model

import com.google.gson.annotations.SerializedName

data class User(

    @SerializedName("login")
    var login: String? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("avatar_url")
    var avatar_url: String? = null,

    @SerializedName("node_id")
    var node_id: String? = null,

    @SerializedName("url")
    var url: String? = null,

    @SerializedName("followers_url")
    var followers_url: String? = null,

    @SerializedName("following_url")
    var following_url: String? = null,

    @SerializedName("gists_url")
    var gists_url: String? = null,

    @SerializedName("starred_url")
    var starred_url: String? = null,

    @SerializedName("subscriptions_url")
    var subscriptions_url: String? = null,

    @SerializedName("organizations_url")
    var organizations_url: String? = null,

    @SerializedName("repos_url")
    var repos_url: String? = null,

    @SerializedName("events_url")
    var events_url: String? = null,

    @SerializedName("received_events_url")
    var received_events_url: String? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("site_admin")
    var site_admin: String? = null,


)

data class UserResponse (
    val user: List<User>
)