package me.loader.app.home.presentaions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import me.loader.app.base.BaseSingleUseCase
import me.loader.app.base.Params
import me.loader.app.data.FeedModel
import me.loader.app.data.HomeFeedRequestParams

class HomeViewModelFactory(private val getHomeFeedUseCase:BaseSingleUseCase<List<FeedModel>, HomeFeedRequestParams>) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(getHomeFeedUseCase) as T

    }
}
