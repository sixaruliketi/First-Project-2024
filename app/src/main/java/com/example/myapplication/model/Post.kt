package com.example.myapplication.model

data class Post(
    val userAvatar: String ?= null,
    var userID : String ?= null,
    val location : String ?= null,
    val postPhoto : String ?= null
)