package sahak.sahakyan.github.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import sahak.sahakyan.github.common.Constants.LOG_TAG
import sahak.sahakyan.github.data.remote.RetrofitClient
import sahak.sahakyan.github.presentation.state.UserState
import javax.inject.Inject

@HiltViewModel
class UserViewModel
@Inject constructor(
    private val retrofitClient: RetrofitClient
) : ViewModel() {

    private val _userResponse = MutableLiveData<UserState>(UserState())
    val userResponse: LiveData<UserState> get() = _userResponse

    init {
        fetchUser()
    }

    private fun fetchUser() {
        val job = viewModelScope.launch {
        Log.d(LOG_TAG.plus("-UserViewModel"), "Starting fetching user")
            try {
                val response = retrofitClient.userService.getUsers()

                _userResponse.value = _userResponse.value!!.copy(
                    loading = false,  userResponse = response, error = null
                )
            } catch (e: Exception) {
                _userResponse.value = _userResponse.value!!.copy(
                    loading = false,
                    error = "Error fetching Crypto: ${e.message}"
                )
                Log.e("Fetch Errors", "Error fetching Crypto: ${e.message}")
                Log.e("Fetch Errors", "${e.cause}")
            }
        }

        viewModelScope.launch(Dispatchers.Main) {
            job.join()
        }
    }

}