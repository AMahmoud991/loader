package me.loader.app.home.model

import io.reactivex.Single
import me.loader.app.base.ThreadExecutor
import me.loader.app.data.FeedModel
import me.loader.app.data.UserModel
import me.loader.loaderlib.parser.BaseParser
import me.loader.loaderlib.request.Request
import me.loader.loaderlib.request.RequestCall
import org.json.JSONArray
import org.json.JSONException

class HomeFeedRemoteDataSource(var jsonArrayParser: BaseParser<JSONArray>,
                               var backgroundThreadExecutor: ThreadExecutor) : HomeFeedDataSource{
    override fun getUserFeed(url: String): Single<List<FeedModel>> =
        RequestCall(Request(method = Request.GET, url = url, parser = jsonArrayParser)).getData().subscribeOn(backgroundThreadExecutor.scheduler).flatMap {
            Single.just(parseData(it))
        }

    private fun parseData(data: JSONArray): List<FeedModel> {

        val feedModels = mutableListOf<FeedModel>()
        var i = 0
        while (i < data.length()) {
            try {
                val jsonObject = data.getJSONObject(i)
                val userJsonObject = jsonObject.getJSONObject("user")
                val userModel = UserModel(
                    id = userJsonObject.getString("id"),
                    userName = userJsonObject.getString("username"),
                    profileIamge = userJsonObject.getJSONObject("profile_image").getString("large")
                )
                val feedModel = FeedModel(
                    id = jsonObject.getString("id"),
                    color = jsonObject.getString("color"),
                    likes = jsonObject.getInt("likes"),
                    width = jsonObject.getInt("width"),
                    height = jsonObject.getInt("height"),
                    liked_by_user = jsonObject.getBoolean("liked_by_user"),
                    userModel = userModel
                )

                feedModels.add(feedModel)
            } catch (e: JSONException) {
                e.printStackTrace()
            }

            i++
        }
        return feedModels
    }

}

