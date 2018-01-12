package jp.takuji31.koreference.test

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.observable.KoreferenceObservableModel
import jp.takuji31.koreference.observable.getValueAsSingle
import jp.takuji31.koreference.observable.observe
import jp.takuji31.koreference.observable.enableObservableSupport
import jp.takuji31.koreference.stringPreference

class TestKoreferenceModel(pref: SharedPreferences) : KoreferenceObservableModel(sharedPreferences = pref) {
    var stringValue: String by stringPreference(default = "default value").enableObservableSupport()
    private var privateStringValue: String by stringPreference(default = "this is private property").enableObservableSupport()
    val privateStringValueObservable: Observable<String> = observe(::privateStringValue)
    val privateStringValueSingle: Single<String> = getValueAsSingle(::privateStringValue)
    var noKoreferenceProperty: String = ""

    fun putPrivateStringValue(value: String) {
        privateStringValue = value
    }
}