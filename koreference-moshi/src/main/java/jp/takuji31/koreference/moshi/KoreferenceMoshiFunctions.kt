package jp.takuji31.koreference.moshi

import com.squareup.moshi.JsonAdapter
import jp.takuji31.koreference.moshi.property.MoshiKoreferenceProperty

fun <T : Any> moshiPreference(jsonAdapter: JsonAdapter<T>, default : T, key: String? = null): MoshiKoreferenceProperty<T> {
    return MoshiKoreferenceProperty(default, key, jsonAdapter)
}

fun <T : Any> nullableMoshiPreference(jsonAdapter: JsonAdapter<T?>, default : T? = null, key: String? = null): MoshiKoreferenceProperty<T?> {
    return MoshiKoreferenceProperty(default, key, jsonAdapter)
}
