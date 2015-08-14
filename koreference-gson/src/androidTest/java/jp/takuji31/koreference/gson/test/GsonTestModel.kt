package jp.takuji31.koreference.gson.test

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import jp.takuji31.koreference.Koreference
import jp.takuji31.koreference.gson
import jp.takuji31.koreference.gson.gsonPreference
import kotlin.properties.Delegates

/**
 * Created by takuji on 2015/08/14.
 */
public class GsonTestModel(pref : SharedPreferences) : SharedPreferences by pref {
    var person : Person by gsonPreference(default = Person("Taro", "Yamada"))
    var nullablePerson : Person? by gsonPreference()
}