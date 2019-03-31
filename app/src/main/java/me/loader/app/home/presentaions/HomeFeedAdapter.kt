package me.loader.app.home.presentaions

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import me.loader.app.R
import me.loader.app.base.ThreadExecutor
import me.loader.app.data.FeedModel
import me.loader.loaderlib.widget.LoaderImageView


class HomeFeedAdapter(
    data: MutableList<FeedModel>?,
    var onFeedItemClicked: (FeedModel) -> Unit = {}
) :
    BaseQuickAdapter<FeedModel, BaseViewHolder>(R.layout.home_feed_item, data) {

    override fun convert(helper: BaseViewHolder?, item: FeedModel?) {
        if (helper != null && item != null) {
            with(helper) {
getView<LoaderImageView>(R.id.userImage).loadImage(item.userModel.profileIamge)
    setText(R.id.userName,item.userModel.userName)
//setTextColor(R.id.userName,item.color)
//                feedViewHolder.userName.setBackgroundColor(Color.parseColor(feedModel.getColor()))
//                feedViewHolder.userName.setTextColor(Color.parseColor(feedModel.getTextColor()))

//                feedViewHolder.containerLayout.setOnClickListener(View.OnClickListener {
//                    if (itemCLickListener != null) {
//                        itemCLickListener.onItemCLickListener(
//                            position,
//                            feedModel,
//                            feedViewHolder.userImage.findViewById(R.id.imageView)
//                        )
//                    }
//                })
            }
        }
    }
}