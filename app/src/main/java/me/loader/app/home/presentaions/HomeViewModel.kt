package me.loader.app.home.presentaions

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxkotlin.subscribeBy
import me.loader.app.base.BaseSingleUseCase
import me.loader.app.data.FeedModel
import me.loader.app.data.HomeFeedRequestParams

class HomeViewModel(private val homeFeedUseCase: BaseSingleUseCase<List<FeedModel>, HomeFeedRequestParams>) :
    ViewModel() {
    val homeFeedItemList= mutableListOf<FeedModel>()
    val homeFeedItemObservable = MutableLiveData<List<FeedModel>>()
    val loadMoreHomeFeedItemObservable = MutableLiveData<Boolean>()
    var pageNumber=0

    fun getHomeFeed() {
        pageNumber+=1
        homeFeedUseCase.getSingle(HomeFeedRequestParams(pageNumber.toString())).subscribeBy(onSuccess = {
           homeFeedItemList.addAll(it)
            if (pageNumber==1){
            homeFeedItemObservable.postValue(homeFeedItemList)}else{
                loadMoreHomeFeedItemObservable.postValue(true)
            }
        })
    }

}
