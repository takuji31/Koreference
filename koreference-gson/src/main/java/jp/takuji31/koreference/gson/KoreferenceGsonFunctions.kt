package jp.takuji31.koreference.gson

import com.google.gson.Gson
import jp.takuji31.koreference.gson.converter.typeToken
import jp.takuji31.koreference.gson.property.GsonKoreferenceProperty
import jp.takuji31.koreference.property.PropertyProvider
import jp.takuji31.koreference.property.toPropertyProvider

inline fun <reified T> gsonPreference(gson: Gson = Gson(), default : T, key: String? = null): PropertyProvider<T> {
    val type = typeToken<T>()
    return GsonKoreferenceProperty(default, key, gson, type).toPropertyProvider()
}

inline fun <reified T : Any> nullableGsonPreference(gson: Gson = Gson(), default : T? = null, key: String? = null): PropertyProvider<T?> {
    val type = typeToken<T>()
    return GsonKoreferenceProperty(default, key, gson, type).toPropertyProvider()
}
