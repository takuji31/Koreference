package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface StringPreference : Preference<String?> {
    override fun get(pref: SharedPreferences, key: String, default: String?): String? {
        return pref.getString(key, default)
    }

    override fun put(editor: SharedPreferences.Editor, key: String, value: String?) {
        editor.putString(key, value)
    }
}