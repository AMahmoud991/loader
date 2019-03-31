package me.loader.app.home.di

import androidx.lifecycle.ViewModelProviders
import me.loader.app.base.BaseSingleUseCase
import me.loader.app.base.Params
import me.loader.app.data.FeedModel
import me.loader.app.data.HomeFeedRequestParams
import me.loader.app.home.model.*
import me.loader.app.home.presentaions.HomeViewModel
import me.loader.app.home.presentaions.HomeViewModelFactory
import me.loader.loaderlib.parser.BaseParser
import me.loader.loaderlib.parser.JsonArrayParser
import org.json.JSONArray
import org.kodein.di.Kodein
import org.kodein.di.generic.*

val homeFeedModule = Kodein.Module(name = "homeFeedModule") {
    bind<HomeViewModel>() with factory { fragment: androidx.fragment.app.Fragment ->
        ViewModelProviders.of(fragment, HomeViewModelFactory(instance("getHomeFeedUseCase"))).get(HomeViewModel::class.java)
    }
    bind<BaseSingleUseCase<List<FeedModel>, HomeFeedRequestParams>>("getHomeFeedUseCase") with provider {
        HomeFeedUseCase(instance(), instance(), instance("homeFeedDataSource"),instance("homeFeedUrl"))
    }
    bind<HomeFeedDataSource>("homeFeedRemoteDataSource") with singleton {
        HomeFeedRemoteDataSource(instance("jsonArrayParser"),instance())
    }
    bind<HomeFeedDataSource>("homeFeedLocalDataSource") with singleton {
        HomeFeedLocalDataSource()
    }
    bind<HomeFeedDataSource>("homeFeedDataSource") with singleton {
        HomeFeedRepository(instance("homeFeedRemoteDataSource"),instance("homeFeedLocalDataSource"))
    }
    constant( "homeFeedUrl") with "http://pastebin.com/raw/wgkJgazE"

    bind<BaseParser<JSONArray>>("jsonArrayParser") with singleton {
        JsonArrayParser()
    }

}