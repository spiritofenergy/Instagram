package com.kodex.instagram.domain.model

data class Post(
    var postId : String = "",
    var postImage : String = "",
    var postDescription : String = "",
    var time : Long? = null,
    var userId : String = "",
    var usrImage: String = "",
    var userName : String = ""
    )
