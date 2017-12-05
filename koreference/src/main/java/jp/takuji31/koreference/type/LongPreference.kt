package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface LongPreference : Preference<Long> {
    override fun get(pref: SharedPreferences, key: String, default: Long): Long {
        return pref.getLong(key, default)
    }

    override fun put(editor: SharedPreferences.Editor, key: String, value: Long) {
        editor.putLong(key, value)
    }
}