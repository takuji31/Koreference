package jp.takuji31.koreference.gson.test

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.gson.moshiPreference
import jp.takuji31.koreference.gson.nullableMoshiPreference

class MoshiTestModel(pref: SharedPreferences, moshi: Moshi) : KoreferenceModel(sharedPreferences = pref) {
    var person: Person by moshiPreference(jsonAdapter = moshi.adapter(Person::class.java), default = Person("Taro", "Yamada"))
    var nullablePerson: Person? by nullableMoshiPreference(jsonAdapter = moshi.adapter(Person::class.java))
}