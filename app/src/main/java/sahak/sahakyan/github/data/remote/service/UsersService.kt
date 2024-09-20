package sahak.sahakyan.github.data.remote.service

import retrofit2.http.GET
import sahak.sahakyan.github.data.model.User

interface UsersService {
    @GET("/users")
    suspend fun getUsers(): List<User>
}