package sahak.sahakyan.github.presentation.state

import sahak.sahakyan.github.data.model.UserInfo

data class UserInfoState(
    val loading: Boolean = true,
    val userResponse: UserInfo = UserInfo(),
    val error: String? = null
)
