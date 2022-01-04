package com.tomuchcoffee.githubuser.api


import com.tomuchcoffee.githubuser.BuildConfig
import com.tomuchcoffee.githubuser.data.resource.remote.model.DetailResponse
import com.tomuchcoffee.githubuser.data.resource.remote.model.ItemsItem
import com.tomuchcoffee.githubuser.data.resource.remote.model.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    @Headers("Authorization: token ${BuildConfig.API_KEY}")
    suspend fun searchUserName(
        @Query("q") username: String
    ): Call<UsersResponse>

    @GET("users/{username}")
    @Headers("Authorization: token ${BuildConfig.API_KEY}")
    suspend fun getUserDetails(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{login}/followers")
    @Headers("Authorization: token ${BuildConfig.API_KEY}")
    fun getUserFollowers(
        @Path("login") login: String
    ): Call<List<ItemsItem>>

    @GET("users/{login}/following")
    @Headers("Authorization: token ${BuildConfig.API_KEY}")
    fun getUserFollowings(
        @Path("login") login: String
    ): Call<List<ItemsItem>>
}