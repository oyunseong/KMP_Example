package com.oys.myapplication.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CancellationException

interface TestApi {
    suspend fun getData(): List<UserResponse>
}

class KtorTestApi(private val client: HttpClient) : TestApi {
    companion object {
        private const val API_URL =
            "https://jsonplaceholder.typicode.com/posts"
    }

    override suspend fun getData(): List<UserResponse> {
        return try {
            client.get(API_URL).body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            emptyList()
        }
    }

}