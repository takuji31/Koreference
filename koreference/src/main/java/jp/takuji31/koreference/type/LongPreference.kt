package jp.takuji31.koreference.type

import android.content.SharedPreferences
import jp.takuji31.koreference.type.Preference

/**
 * Created by takuji on 2015/08/14.
 */
public interface LongPreference : Preference<Long> {
    override fun get(pref: SharedPreferences, key: String, default: Long): Long {
        return pref.getLong(key, default)
    }

    override fun set(editor: SharedPreferences.Editor, key: String, value: Long) {
        editor.putLong(key, value)
    }
}