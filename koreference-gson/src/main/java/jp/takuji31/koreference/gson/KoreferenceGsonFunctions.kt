package jp.takuji31.koreference.gson

import com.google.gson.Gson
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.gson.converter.GsonConverter
import jp.takuji31.koreference.gson.converter.typeToken
import jp.takuji31.koreference.type.NullableStringPreference
import java.lang.reflect.Type

/**
 * Created by takuji on 2015/08/14.
 */
inline fun <reified T> gsonPreference(gson: Gson = Gson(), default : T, name: String? = null): KoreferenceProperty<String?, T> {
    val type = typeToken<T>()
    return object : KoreferenceProperty<String?, T> (default, name), NullableStringPreference, GsonConverter<T> {
        override val type: Type = type
        override val gson : Gson = gson
    }
}

inline fun <reified T : Any> nullableGsonPreference(gson: Gson = Gson(), default : T? = null, name: String? = null): KoreferenceProperty<String?, T?> {
    val type = typeToken<T>()
    return object : KoreferenceProperty<String?, T?> (default, name), NullableStringPreference, GsonConverter<T?> {
        override val type: Type = type
        override val gson : Gson = gson
    }
}
