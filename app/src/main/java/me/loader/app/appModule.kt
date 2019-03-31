package me.loader.app

import me.loader.app.base.di.baseModule
import me.loader.app.home.di.homeFeedModule
import org.kodein.di.Kodein


val appModule = Kodein.Module(name="appModule") {
    import(baseModule)
    import(homeFeedModule)
}