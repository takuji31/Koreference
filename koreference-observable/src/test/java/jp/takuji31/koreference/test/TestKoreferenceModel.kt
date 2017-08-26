package jp.takuji31.koreference.test

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.observable.getValueAsSingle
import jp.takuji31.koreference.observable.observe
import jp.takuji31.koreference.stringPreference

class TestKoreferenceModel(pref: SharedPreferences) : KoreferenceModel(pref = pref) {
    var stringValue: String by stringPreference(default = "default value")
    private var privateStringValue : String by stringPreference(default = "this is private property")
    val privateStringValueObservable : Observable<String> = observe(TestKoreferenceModel::privateStringValue)
    val privateStringValueSingle : Single<String> = getValueAsSingle(TestKoreferenceModel::privateStringValue)
    var noKoreferenceProperty: String = ""

    fun putPrivateStringValue(value: String) {
        privateStringValue = value
    }
}