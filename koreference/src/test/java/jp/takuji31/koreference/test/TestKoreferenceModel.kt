package jp.takuji31.koreference.test

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.*
import jp.takuji31.koreference.observable.getValueAsSingle
import jp.takuji31.koreference.observable.observe

/**
 * Created by takuji on 2015/08/10.
 */
class TestKoreferenceModel(pref: SharedPreferences) : KoreferenceModel(sharedPreferences = pref) {
    var stringValue: String by stringPreference("default value")
    var intValue: Int by intPreference(256)
    var longValue: Long by longPreference(256L)
    var floatValue: Float by floatPreference(12.34f)
    var boolValue: Boolean by booleanPreference(true)
    var stringSetValue: Set<String> by stringSetPreference(setOf())
    private var privateStringValue : String by stringPreference(default = "this is private property")
    val privateStringValueObservable : Observable<String> = observe(TestKoreferenceModel::privateStringValue)
    val privateStringValueSingle : Single<String> = getValueAsSingle(TestKoreferenceModel::privateStringValue)
    var noKoreferenceProperty: String = ""

    fun putPrivateStringValue(value: String) {
        privateStringValue = value
    }
}