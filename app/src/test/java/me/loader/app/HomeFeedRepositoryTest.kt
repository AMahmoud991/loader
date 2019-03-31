package me.loader.app


import com.nhaarman.mockito_kotlin.clearInvocations
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever

import io.reactivex.Single
import me.loader.app.data.FeedModel
import me.loader.app.home.model.HomeFeedDataSource
import me.loader.app.home.model.HomeFeedRepository
import org.amshove.kluent.any
import org.amshove.kluent.mock
import org.junit.Before
import org.junit.Test


class HomeFeedRepositoryTest {
    private val remoteDataSource = mock<HomeFeedDataSource>()

    private lateinit var repository: HomeFeedRepository

    @Before
    fun setUp() {
        clearInvocations(remoteDataSource)

        repository = HomeFeedRepository(remoteDataSource)
    }

    @Test
    fun getHomeFeed() {
        val homeFeedResult = listOf<FeedModel>()
        whenever(remoteDataSource.getUserFeed(any())) doReturn Single.just(homeFeedResult)

        val url = "http://pastebin.com/raw/wgkJgazE"

        val observer = repository.getUserFeed(url).test()

        observer.awaitTerminalEvent()

        verify(remoteDataSource).getUserFeed(url)

        observer.assertResult(homeFeedResult)
    }

}