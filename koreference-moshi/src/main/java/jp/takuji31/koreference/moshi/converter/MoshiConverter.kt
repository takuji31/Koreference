package jp.takuji31.koreference.gson.converter

import com.squareup.moshi.JsonAdapter
import jp.takuji31.koreference.converter.ValueConverter

/**
 * Created by takuji on 2015/08/14.
 */
class MoshiConverter<T : Any?>(val gson: JsonAdapter<T>, private val defaultValue: T) : ValueConverter<String?, T> {
    override fun toPreferenceValue(value: T): String? {
        return if (value != null) gson.toJson(value) else null
    }

    override fun toModelValue(value: String?): T {
        return value?.let { gson.fromJson(it) } ?: defaultValue
    }
}