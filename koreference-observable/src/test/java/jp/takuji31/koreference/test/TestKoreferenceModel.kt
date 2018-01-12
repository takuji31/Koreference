package jp.takuji31.koreference.test

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.observable.KoreferenceObservableModel
import jp.takuji31.koreference.observable.getValueAsSingle
import jp.takuji31.koreference.observable.observe
import jp.takuji31.koreference.observable.withObservableSupport
import jp.takuji31.koreference.stringPreference

class TestKoreferenceModel(pref: SharedPreferences) : KoreferenceObservableModel(sharedPreferences = pref) {
    var stringValue: String by stringPreference(default = "default value").withObservableSupport()
    private var privateStringValue: String by stringPreference(default = "this is private property").withObservableSupport()
    val privateStringValueObservable: Observable<String> = observe(::privateStringValue)
    val privateStringValueSingle: Single<String> = getValueAsSingle(::privateStringValue)
    var noKoreferenceProperty: String = ""

    fun putPrivateStringValue(value: String) {
        privateStringValue = value
    }
}