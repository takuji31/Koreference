package jp.takuji31.koreference.test

import android.content.SharedPreferences
import jp.takuji31.koreference.*
import java.util.*

/**
 * Created by takuji on 2015/08/10.
 */
public class TestPreferenceModel(pref : SharedPreferences) : SharedPreferences by pref {
    var stringValue : String by stringPreference("default value")
    var intValue : Int by intPreference(256)
    var longValue : Long by longPreference(256L)
    var floatValue : Float by floatPreference(12.34f)
    var boolValue : Boolean by booleanPreference(true)
    var stringSetValue : Set<String> by stringSetPreference(setOf())
}