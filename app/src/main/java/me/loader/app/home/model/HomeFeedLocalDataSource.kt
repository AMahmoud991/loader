package me.loader.app.home.model

import io.reactivex.Single
import me.loader.app.data.FeedModel

class HomeFeedLocalDataSource:HomeFeedDataSource{
    override fun getUserFeed(url:String) : Single<List<FeedModel>> {
        TODO("not implemented") // To be Implemented When Disk Storage is needed
    }
}