package sahak.sahakyan.github.data.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("avatar_url")
    var avatar_url: String? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("location")
    var location: String? = null,

    @SerializedName("followers")
    var followers: Int = 0,
    @SerializedName("following")
    var following: Int = 0,

    @SerializedName("bio")
    var bio: String? = null,

    @SerializedName("public_repos")
    var public_repos: Int = 0,
    @SerializedName("public_gists")
    var public_gists: Int = 0,

    @SerializedName("updated_at")
    var updated_at: String? = null,
)

data class UserInfoResponse(
    var user: UserInfo? = null,
    var message: String? = null,
)