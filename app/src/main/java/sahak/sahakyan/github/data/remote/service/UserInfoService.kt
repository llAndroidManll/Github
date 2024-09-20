package sahak.sahakyan.github.data.remote.service

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import sahak.sahakyan.github.data.model.UserInfo

interface UserInfoService {
    @GET("users/{login}")
    suspend fun getUserInfo(@Path("login") username: String): Response<UserInfo>
}