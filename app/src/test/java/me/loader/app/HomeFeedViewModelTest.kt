package me.loader.app

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockito_kotlin.*
import io.reactivex.Single
import me.loader.app.base.BaseSingleUseCase
import me.loader.app.data.FeedModel
import me.loader.app.data.HomeFeedRequestParams
import me.loader.app.home.presentaions.HomeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class HomeFeedViewModelTest {
    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    var homeFeedItems = FeedModel.TestBuilder.buildList()
    var params = HomeFeedRequestParams("1")

    private val loadHomeFeed = mock<BaseSingleUseCase<List<FeedModel>, HomeFeedRequestParams>>{
        on { getSingle(params) } doReturn Single.just(homeFeedItems)
    }



    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        clearInvocations(loadHomeFeed)

        viewModel = HomeViewModel(loadHomeFeed)
    }

    @Test
    fun loadFeedModelFromUseCase() {
        loadHomeFeed.getSingle(params)
        verify(loadHomeFeed).getSingle(params)
    }

}