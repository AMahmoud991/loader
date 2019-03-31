package me.loader.app.base

import io.reactivex.Single

interface SingleUseCase<T, P : Params> {
    fun getSingle(params: P? = null): Single<T>
}