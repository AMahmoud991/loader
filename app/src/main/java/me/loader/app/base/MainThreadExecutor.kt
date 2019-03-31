package me.loader.app.base

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class MainThreadExecutor : PostThreadExecutor {
    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()
}