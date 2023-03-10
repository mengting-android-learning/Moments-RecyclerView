package com.example.momentsrecyclerview.network

import com.example.momentsrecyclerview.domain.UserInfo
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetworkUserInfo(
    @Json(name = "profile-image") val profileImageUrl: String,
    @Json(name = "avatar") val avatarUrl: String,
    val nick: String,
    @Json(name = "username") val userName: String
)

fun NetworkUserInfo.asDomainModel() = let {
    UserInfo(
        profileImageUrl = it.profileImageUrl,
        avatarUrl = it.avatarUrl,
        nick = it.nick,
        userName = it.userName
    )
}
