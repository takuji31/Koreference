package jp.takuji31.koreference

import android.content.SharedPreferences
import java.util.*

/**
 * Created by takuji on 2015/08/10.
 */
public class TestPreferenceModel(pref : SharedPreferences) : SharedPreferences by pref {
    var stringValue : String by Koreference.string("default value")
    var intValue : Int by Koreference.int(256)
    var longValue : Long by Koreference.long(256L)
    var floatValue : Float by Koreference.float(12.34f)
    var boolValue : Boolean by Koreference.boolean(true)
    var stringSetValue : Set<String> by Koreference.stringSet(HashSet<String>())
}