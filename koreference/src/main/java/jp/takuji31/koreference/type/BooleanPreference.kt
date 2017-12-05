package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface BooleanPreference : Preference<Boolean> {
    override fun get(pref: SharedPreferences, key: String, default: Boolean): Boolean {
        return pref.getBoolean(key, default)
    }

    override fun put(editor: SharedPreferences.Editor, key: String, value: Boolean) {
        editor.putBoolean(key, value)
    }
}