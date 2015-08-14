package jp.takuji31.koreference

import android.content.SharedPreferences
import java.util.*

/**
 * Created by takuji on 2015/08/14.
 */
public class TestNullablePreferenceModel(pref : SharedPreferences) : SharedPreferences by pref {
    var stringValue : String? by Koreference.nullableString()
    var stringSetValue : Set<String>? by Koreference.nullableStringSet()
}