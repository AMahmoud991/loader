package me.loader.app.base

import io.reactivex.Scheduler

interface PostThreadExecutor {
    val scheduler: Scheduler
}