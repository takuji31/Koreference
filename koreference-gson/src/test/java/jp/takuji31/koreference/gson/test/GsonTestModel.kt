package jp.takuji31.koreference.gson.test

import android.content.SharedPreferences
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.gson.gsonPreference
import jp.takuji31.koreference.gson.nullableGsonPreference

/**
 * Created by takuji on 2015/08/14.
 */
class GsonTestModel(pref: SharedPreferences) : KoreferenceModel(sharedPreferences = pref) {
    var person: Person by gsonPreference(default = Person("Taro", "Yamada"))
    var nullablePerson: Person? by nullableGsonPreference()
}