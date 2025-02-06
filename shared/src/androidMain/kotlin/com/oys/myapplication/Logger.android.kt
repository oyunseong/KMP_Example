package com.oys.myapplication

import android.util.Log

// commonMain
actual object Logger {
    actual fun d(tag: String, message: String) {
        Log.d(tag, message)
    }
}