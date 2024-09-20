package sahak.sahakyan.github.presentation.state

import sahak.sahakyan.github.data.model.User

data class UserState(
    val loading: Boolean = true,
    val userResponse: List<User> = emptyList<User>(),
    val error: String? = null
)
