package com.kishan.cryptocurrency.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kishan.cryptocurrency.data.remote.dto.Links
import com.kishan.cryptocurrency.data.util.JsonParser


@ProvidedTypeConverter
class LinksConverter(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromJson(json: String?): Links {
        return json?.let {
            jsonParser.fromJson(it, Links::class.java) ?: Links(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
        } ?: Links(emptyList(), emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
    }

    @TypeConverter
    fun toJson(links: Links?): String {
        return links?.let {
            jsonParser.toJson(it, Links::class.java) ?: "{}"
        } ?: "{}"
    }
}