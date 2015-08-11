package jp.takuji31.koreference

import android.content.SharedPreferences
import java.util.*

/**
 * Created by takuji on 2015/08/10.
 */
public class TestPreferenceModel(pref : SharedPreferences) : SharedPreferences by pref {
    var stringValue : String by Koreference.String("default value")
    var intValue : Int by Koreference.Int(256)
    var longValue : Long by Koreference.Long(256L)
    var floatValue : Float by Koreference.Float(12.34f)
    var boolValue : Boolean by Koreference.Boolean(true)
    var stringSetValue : Set<String> by Koreference.StringSet(HashSet<String>())
}