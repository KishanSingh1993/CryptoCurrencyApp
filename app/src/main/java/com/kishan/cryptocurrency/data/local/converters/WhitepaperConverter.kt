package com.kishan.cryptocurrency.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kishan.cryptocurrency.data.remote.dto.Whitepaper
import com.kishan.cryptocurrency.data.util.JsonParser

@ProvidedTypeConverter
class WhitepaperConverter(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromJson(json: String?): Whitepaper {
        return json?.let {
            jsonParser.fromJson(it, Whitepaper::class.java) ?: Whitepaper("", "")
        } ?: Whitepaper("", "")
    }

    @TypeConverter
    fun toJson(whitepaper: Whitepaper?): String {
        return whitepaper?.let {
            jsonParser.toJson(it, Whitepaper::class.java) ?: "{}"
        } ?: "{}"
    }
}