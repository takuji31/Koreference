package jp.takuji31.koreference.moshi.property

import com.squareup.moshi.JsonAdapter
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.moshi.converter.MoshiConverter
import jp.takuji31.koreference.store.Stores

/**
 * Created by takuji on 2017/12/05.
 */
class MoshiKoreferenceProperty<T: Any?>(
    default: T,
    preferenceKey: String?,
    moshi: JsonAdapter<T>
) : KoreferenceProperty<String?, T>(default, preferenceKey, MoshiConverter<T>(moshi, default), Stores.String)