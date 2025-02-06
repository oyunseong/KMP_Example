package com.oys.myapplication.data

class UserRepository(
    private val testApi: TestApi,
) {
    // 필요한 경우 CoroutineScope를 사용하여 코루틴을 관리할 수 있습니다.
//    private val scope = CoroutineScope(SupervisorJob())

    suspend fun getData(): List<UserResponse> {
        return testApi.getData()
    }
}