package com.oys.myapplication.data

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)