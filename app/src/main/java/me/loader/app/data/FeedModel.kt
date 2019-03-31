package me.loader.app.data

data class FeedModel(
    var id: String, var width: Int, var height: Int = 0, var color: String,
    var likes: Int,
    var liked_by_user: Boolean,
    var userModel: UserModel){
    class TestBuilder {
        companion object {
            fun buildTestFeedModel() =
               FeedModel(id="12",width = 1,height = 1,color = "#12123",liked_by_user = true,likes = 1000,userModel = UserModel.TestBuilder.buildUserModel())

            fun buildList() =
                listOf(buildTestFeedModel())
        }
    }
}