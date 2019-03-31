package me.loader.app.home.model

import io.reactivex.Single
import me.loader.app.data.FeedModel

interface HomeFeedDataSource {
    fun getUserFeed(url: String): Single<List<FeedModel>>
}