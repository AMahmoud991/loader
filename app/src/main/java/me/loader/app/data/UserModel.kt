package me.loader.app.data


data class UserModel(
    var id: String,
    var userName: String,
    var profileIamge: String)
    {
        class TestBuilder {
            companion object {
                fun buildUserModel() =
                    UserModel(id="12",userName = "Test",profileIamge = "hey pic")

                fun buildList() =
                    listOf(buildUserModel())
            }
        }

}


