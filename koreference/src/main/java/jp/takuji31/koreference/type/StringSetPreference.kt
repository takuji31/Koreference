package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface StringSetPreference : Preference<Set<String>?> {
    override fun get(pref: SharedPreferences, key: String, default: Set<String>?): Set<String>? {
        return pref.getStringSet(key, default)
    }

    override fun put(editor: SharedPreferences.Editor, key: String, value: Set<String>?) {
        editor.putStringSet(key, value)
    }
}