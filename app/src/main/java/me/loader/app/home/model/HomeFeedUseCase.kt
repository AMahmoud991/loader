package me.loader.app.home.model

import io.reactivex.Single
import me.loader.app.base.BaseSingleUseCase
import me.loader.app.base.PostThreadExecutor
import me.loader.app.base.ThreadExecutor
import me.loader.app.data.FeedModel
import me.loader.app.data.HomeFeedRequestParams

class HomeFeedUseCase(
    threadExecutor: ThreadExecutor,
    postThreadExecutor: PostThreadExecutor,
    private val homeFeedDataSource: HomeFeedDataSource,
    private val requestUrl: String
) : BaseSingleUseCase<List<FeedModel>, HomeFeedRequestParams>(threadExecutor, postThreadExecutor) {
    override fun buildUseCaseSingle(params: HomeFeedRequestParams?): Single<List<FeedModel>> =
        homeFeedDataSource.getUserFeed(requestUrl+"/"+params!!.page)
}