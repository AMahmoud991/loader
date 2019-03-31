package me.loader.app.base.di

import me.loader.app.base.BackgroundThreadExecutor
import me.loader.app.base.MainThreadExecutor
import me.loader.app.base.PostThreadExecutor
import me.loader.app.base.ThreadExecutor
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

val baseModule=Kodein.Module(name="baseModule"){
    bind<ThreadExecutor>() with provider { BackgroundThreadExecutor() }
    bind<PostThreadExecutor>() with provider { MainThreadExecutor() }
}