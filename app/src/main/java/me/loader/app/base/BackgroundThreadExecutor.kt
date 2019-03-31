package me.loader.app.base

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class BackgroundThreadExecutor : ThreadExecutor {
    override val scheduler: Scheduler = Schedulers.io()
}