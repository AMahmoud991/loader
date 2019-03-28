package me.loader.loaderlib.parser

import java.io.InputStream

interface BaseParser<T> {
    fun parse(inputStream: InputStream): T
}