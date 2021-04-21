package uca.edu.reqres.retrofit

import retrofit2.http.GET

interface ReqresRetrofit {
    @GET("users?page=1")
    suspend fun get(): PokemonsAPIResponse
}
