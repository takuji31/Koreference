package jp.takuji31.koreference.gson

import com.google.gson.Gson
import jp.takuji31.koreference.Koreference
import jp.takuji31.koreference.KoreferenceDelegate
import jp.takuji31.koreference.gson.converter.GsonConverter
import jp.takuji31.koreference.gson.converter.typeToken
import jp.takuji31.koreference.type.NullableStringPreference
import java.lang.reflect.Type

/**
 * Created by takuji on 2015/08/14.
 */
public inline fun gsonPreference<reified T : Any?>(gson: Gson = Gson(), default : T = null, name: String? = null): KoreferenceDelegate<T, String?> {
    return object : KoreferenceDelegate<T, String?> (default, name), NullableStringPreference, GsonConverter<T> {
        override val type: Type = typeToken<T>()
        override val gson : Gson = gson
    }
}
