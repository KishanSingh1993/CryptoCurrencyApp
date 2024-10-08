package com.kishan.cryptocurrency.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kishan.cryptocurrency.data.remote.dto.Tag
import com.kishan.cryptocurrency.data.util.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class TagListConverter(private val jsonParser: JsonParser) {
    @TypeConverter
    fun fromJson(json: String?): List<Tag>? {
        return json?.let {
            jsonParser.fromJson<ArrayList<Tag>>(
                it,
                object : TypeToken<ArrayList<Tag>>() {}.type
            ) ?: emptyList()
        }
    }

    @TypeConverter
    fun toJson(tags: List<Tag>?): String {
        return tags?.let {
            jsonParser.toJson(
                it,
                object : TypeToken<ArrayList<Tag>>() {}.type
            ) ?: "[]"
        } ?: "[]"
    }
}