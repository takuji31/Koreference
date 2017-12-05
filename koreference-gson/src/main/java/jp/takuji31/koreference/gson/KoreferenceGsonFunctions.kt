package jp.takuji31.koreference.gson

import com.google.gson.Gson
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.KoreferencePropertyProvider
import jp.takuji31.koreference.gson.converter.typeToken
import jp.takuji31.koreference.gson.property.GsonKoreferenceProperty

inline fun <reified T> gsonPreference(gson: Gson = Gson(), default : T, key: String? = null): KoreferencePropertyProvider<String?, T> {
    val type = typeToken<T>()
    return object : KoreferencePropertyProvider<String?, T>(key, default){
        override fun createDelegate(key: String, defaultValue: T): KoreferenceProperty<String?, T> {
            return GsonKoreferenceProperty(defaultValue, key, gson, type)
        }
    }
}

inline fun <reified T : Any> nullableGsonPreference(gson: Gson = Gson(), default : T? = null, key: String? = null): KoreferencePropertyProvider<String?, T?> {
    val type = typeToken<T>()
    return object : KoreferencePropertyProvider<String?, T?>(key, default){
        override fun createDelegate(key: String, defaultValue: T?): KoreferenceProperty<String?, T?> {
            return GsonKoreferenceProperty(defaultValue, key, gson, type)
        }
    }
}
