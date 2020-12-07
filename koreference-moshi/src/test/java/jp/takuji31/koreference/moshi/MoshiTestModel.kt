package jp.takuji31.koreference.moshi

import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import jp.takuji31.koreference.KoreferenceModel

class MoshiTestModel(pref: SharedPreferences, moshi: Moshi) : KoreferenceModel(sharedPreferences = pref) {
    var person: Person by moshiPreference(jsonAdapter = moshi.adapter(Person::class.java), default = Person("Taro", "Yamada"))
    var nullablePerson: Person? by nullableMoshiPreference(jsonAdapter = moshi.adapter(Person::class.java))
}