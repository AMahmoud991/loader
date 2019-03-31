package me.loader.app.data

data class FeedModel(
    var id: String, var width: Int, var height: Int = 0, var color: String,
    var likes: Int,
    var liked_by_user: Boolean,
    var userModel: UserModel)