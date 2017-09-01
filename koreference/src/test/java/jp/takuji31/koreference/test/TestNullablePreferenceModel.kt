package jp.takuji31.koreference.test

import android.content.SharedPreferences
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.nullableStringPreference
import jp.takuji31.koreference.nullableStringSetPreference

/**
 * Created by takuji on 2015/08/14.
 */
class TestNullablePreferenceModel(pref: SharedPreferences) : KoreferenceModel(sharedPreferences = pref) {
    var stringValue: String? by nullableStringPreference()
    var stringSetValue: Set<String>? by nullableStringSetPreference()
}