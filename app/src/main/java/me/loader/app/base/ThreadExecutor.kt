package me.loader.app.base

import io.reactivex.Scheduler

interface ThreadExecutor {
    val scheduler: Scheduler
}