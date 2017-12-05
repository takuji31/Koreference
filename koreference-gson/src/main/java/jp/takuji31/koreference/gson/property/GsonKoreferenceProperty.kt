package jp.takuji31.koreference.gson.property

import com.google.gson.Gson
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.gson.converter.GsonConverter
import jp.takuji31.koreference.store.Stores
import java.lang.reflect.Type

/**
 * Created by takuji on 2017/12/05.
 */
class GsonKoreferenceProperty<T: Any?>(
        default: T,
        preferenceKey: String,
        gson: Gson,
        type: Type
) : KoreferenceProperty<String?, T>(default, preferenceKey, GsonConverter<T>(gson, type), Stores.String)