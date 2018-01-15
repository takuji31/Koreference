package jp.takuji31.koreference.moshi

import com.squareup.moshi.JsonAdapter
import jp.takuji31.koreference.moshi.property.MoshiKoreferenceProperty
import jp.takuji31.koreference.property.PropertyProvider
import jp.takuji31.koreference.property.toPropertyProvider

fun <T : Any> moshiPreference(jsonAdapter: JsonAdapter<T>, default : T, key: String? = null): PropertyProvider<T> {
    return MoshiKoreferenceProperty(default, key, jsonAdapter).toPropertyProvider()
}

fun <T : Any> nullableMoshiPreference(jsonAdapter: JsonAdapter<T?>, default : T? = null, key: String? = null): PropertyProvider<T?> {
    return MoshiKoreferenceProperty(default, key, jsonAdapter).toPropertyProvider()
}
