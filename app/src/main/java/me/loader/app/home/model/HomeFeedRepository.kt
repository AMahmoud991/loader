package me.loader.app.home.model

import io.reactivex.Single
import me.loader.app.data.FeedModel

class HomeFeedRepository(
    private val remoteHomeFeedDataSource: HomeFeedDataSource,
    private val localHomeFeedDataSource: HomeFeedDataSource
) : HomeFeedDataSource {
    override fun getUserFeed(url: String): Single<List<FeedModel>> =
        remoteHomeFeedDataSource.getUserFeed(url)

}