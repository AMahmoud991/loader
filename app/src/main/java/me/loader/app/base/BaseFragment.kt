package me.loader.app.base


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein



/**
 * Created by mahmoud on 9/8/17.
 */
abstract class BaseFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    abstract val baseViewModel: ViewModel?

    private val NO_LAYOUT_RES_ID = Int.MIN_VALUE


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return if (getLayoutResId() != NO_LAYOUT_RES_ID) {
            inflater.inflate(getLayoutResId(), container, false)
        } else {
            null
        }
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    protected open fun initView(view: View?) {}

    protected abstract fun getLayoutResId(): Int

}