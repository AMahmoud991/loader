package me.loader.app.home.presentaions

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.chad.library.adapter.base.loadmore.LoadMoreView
import kotlinx.android.synthetic.main.home_fragment.*
import me.loader.app.R
import me.loader.app.base.BaseFragment
import org.kodein.di.generic.factory

class HomeFragment : BaseFragment() {
    override fun getLayoutResId(): Int = R.layout.home_fragment

    override val baseViewModel: ViewModel?
        get() = viewModel

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private val viewModelProvider: (HomeFragment) -> HomeViewModel by factory()
    private var homeFeedAdapter = HomeFeedAdapter(mutableListOf(), onFeedItemClicked = {
        //viewModel.f(it)
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = viewModelProvider(this)
        viewModel.getHomeFeed()
        observeHomeFeedData()
        subscribeLoadMoreConversationMessagesSuccess()
    }

    private fun observeHomeFeedData() {
        viewModel.homeFeedItemObservable.observe(this, Observer {
            homeFeedAdapter.setNewData(it)
        })
    }
    private fun subscribeLoadMoreConversationMessagesSuccess() {
        viewModel.loadMoreHomeFeedItemObservable.observe(this, Observer {
            it?.let {
                loadMoreConversationSuccess()
            }
        })
    }

    private fun loadMoreConversationSuccess() {
        homeFeedAdapter.notifyDataSetChanged()
        homeFeedAdapter.loadMoreComplete()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        usersRecyclerView.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = homeFeedAdapter
            addItemDecoration(SpacesItemDecoration(16))
        }
        homeFeedAdapter.apply {
            setEnableLoadMore(true)
            setOnLoadMoreListener({
                viewModel.getHomeFeed()
            }, usersRecyclerView)
        }
    }
}
