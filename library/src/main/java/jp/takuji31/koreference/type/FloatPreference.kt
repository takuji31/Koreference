package jp.takuji31.koreference.type

import android.content.SharedPreferences
import jp.takuji31.koreference.type.Preference

/**
 * Created by takuji on 2015/08/14.
 */
public interface FloatPreference : Preference<Float> {
    override fun get(pref: SharedPreferences, key: String, default: Float): Float {
        return pref.getFloat(key, default)
    }

    override fun set(editor: SharedPreferences.Editor, key: String, value: Float) {
        editor.putFloat(key, value)
    }
}