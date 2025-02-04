package com.oys.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform