package com.example.momentsrecyclerview.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val USER_INFO_URL = "https://tw-mobile-xian.github.io/moments-data/"

interface UserInfoService {
    @GET("user.json")
    suspend fun getUserInfo(): NetworkUserInfo
}

interface TweetsListService {
    @GET("tweets.json")
    suspend fun getTweetsList(): List<NetworkTweet>
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(USER_INFO_URL)
    .build()

object UserInfoNetwork {
    val userInfo: UserInfoService by lazy {
        retrofit.create(UserInfoService::class.java)
    }
}

object TweetsListNetwork {
    val tweets: TweetsListService by lazy {
        retrofit.create(TweetsListService::class.java)
    }
}
