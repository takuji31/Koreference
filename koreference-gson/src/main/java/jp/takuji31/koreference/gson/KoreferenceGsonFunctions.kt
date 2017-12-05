package jp.takuji31.koreference.gson

import com.google.gson.Gson
import jp.takuji31.koreference.gson.converter.typeToken
import jp.takuji31.koreference.gson.property.GsonKoreferenceProperty

inline fun <reified T> gsonPreference(gson: Gson = Gson(), default : T, key: String? = null): GsonKoreferenceProperty<T> {
    val type = typeToken<T>()
    return GsonKoreferenceProperty(default, key, gson, type)
}

inline fun <reified T : Any> nullableGsonPreference(gson: Gson = Gson(), default : T? = null, key: String? = null): GsonKoreferenceProperty<T?> {
    val type = typeToken<T>()
    return GsonKoreferenceProperty(default, key, gson, type)
}
