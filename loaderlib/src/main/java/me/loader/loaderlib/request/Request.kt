package me.loader.loaderlib.request

import me.loader.loaderlib.parser.BaseParser


class Request<T>(var method: String= GET, var url: String, var parser: BaseParser<T>) {
    companion object {
        val POST = "POST"
        val GET = "GET"
        val UPDATE = "UPDATE"
    }
}

