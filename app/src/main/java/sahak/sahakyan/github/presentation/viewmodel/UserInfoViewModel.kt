package sahak.sahakyan.github.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import sahak.sahakyan.github.data.model.UserInfo
import sahak.sahakyan.github.data.remote.RetrofitClient
import sahak.sahakyan.github.presentation.state.UserInfoState
import javax.inject.Inject

@HiltViewModel
class UserInfoViewModel
@Inject constructor(
    private val retrofitClient: RetrofitClient
) : ViewModel() {

    private val _userInfoState = MutableStateFlow(UserInfoState())
    val userInfoState = _userInfoState.asStateFlow()

    fun getUserInfo(login: String) {
        viewModelScope.launch {
            _userInfoState.value = _userInfoState.value.copy(loading = true)

            try {
                val response: Response<UserInfo> = withContext(Dispatchers.IO) {
                    retrofitClient.userInfoService.getUserInfo(login)
                }

                if (response.isSuccessful && response.body() != null) {
                    val userInfo = response.body()!!

                    if (isValidUserInfo(userInfo)) {
                        _userInfoState.value = UserInfoState(
                            userResponse = userInfo,
                            loading = false
                        )
                    } else {
                        _userInfoState.value = UserInfoState(
                            loading = false,
                            error = "Invalid user info received"
                        )
                    }
                } else {
                    _userInfoState.value = UserInfoState(
                        loading = false,
                        error = "Error: ${response.code()} ${response.message()}"
                    )
                }

            } catch (e: Exception) {
                _userInfoState.value = UserInfoState(
                    loading = false,
                    error = "Exception: ${e.message}"
                )
//                Log.e(Constants.COROUTINE_TAG, "Exception: ${e.message}")
            }
        }
    }

    private fun isValidUserInfo(userInfo: UserInfo): Boolean {
        return userInfo.name != null && userInfo.name != "" && userInfo.avatar_url != null && userInfo.avatar_url != ""
    }
}