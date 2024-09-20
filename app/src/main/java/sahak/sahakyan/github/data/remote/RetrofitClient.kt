package sahak.sahakyan.github.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sahak.sahakyan.github.common.Constants
import sahak.sahakyan.github.data.remote.service.UserInfoService
import sahak.sahakyan.github.data.remote.service.UsersService

object RetrofitClient {


    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_KEY)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val userService: UsersService = retrofit.create(UsersService::class.java)
    val userInfoService: UserInfoService = retrofit.create(UserInfoService::class.java)
}