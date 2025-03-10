package com.example.noteappkmmcleancode

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform