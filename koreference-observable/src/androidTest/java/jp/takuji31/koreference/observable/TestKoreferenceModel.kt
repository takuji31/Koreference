package jp.takuji31.koreference.test

import android.content.SharedPreferences
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.stringPreference

class TestKoreferenceModel(pref: SharedPreferences) : KoreferenceModel(pref = pref) {
    var stringValue: String by stringPreference("default value")
    var noKoreferenceProperty: String = ""
}