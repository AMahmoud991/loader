package me.loader.app.base

import io.reactivex.Single

abstract class BaseSingleUseCase<T, P : Params> protected constructor(protected val threadExecutor: ThreadExecutor
                                                                      , protected val postThreadExecutor: PostThreadExecutor) : SingleUseCase<T, P> {
    protected abstract fun buildUseCaseSingle(params: P?): Single<T>

    override fun getSingle(params: P?): Single<T> =
            buildUseCaseSingle(params).subscribeOn(threadExecutor.scheduler)
                    .observeOn(postThreadExecutor.scheduler)
}