package com.example.myapplication.model

data class Post(
    val userAvatar: Int,
    val userID : String ?= null,
    val location : String ?= null,
    val postPhoto : Int
)
