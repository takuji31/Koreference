package jp.takuji31.koreference.gson.converter

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import jp.takuji31.koreference.converter.ValueConverter
import java.lang.reflect.Type

/**
 * Created by takuji on 2015/08/14.
 */
inline fun <reified T> typeToken() : Type {
    return object : TypeToken<T>() {}.type
}
class GsonConverter<T : Any?>(val gson: Gson, val type: Type) : ValueConverter<String?, T> {
    override fun toPreferenceValue(value: T): String? {
        return if (value != null) gson.toJson(value) else null
    }

    override fun toModelValue(value: String?): T {
        return gson.fromJson(value, type)
    }
}