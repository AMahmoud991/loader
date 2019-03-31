package me.loader.loaderlib.parser

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.InputStream

class BitmapParser : BaseParser<Bitmap> {
    override fun parse(inputStream: InputStream): Bitmap =
        BitmapFactory.decodeStream(inputStream)

}