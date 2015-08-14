package jp.takuji31.koreference.type

import android.content.SharedPreferences
import jp.takuji31.koreference.type.Preference

/**
 * Created by takuji on 2015/08/14.
 */
public interface NullableStringPreference : Preference<String?> {
    override fun get(pref: SharedPreferences, key: String, default: String?): String? {
        return pref.getString(key, default)
    }

    override fun set(editor: SharedPreferences.Editor, key: String, value: String?) {
        editor.putString(key, value)
    }
}