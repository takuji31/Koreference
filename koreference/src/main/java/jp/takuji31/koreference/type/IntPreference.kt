package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface IntPreference : Preference<Int> {
    override fun get(pref: SharedPreferences, key: String, default: Int): Int {
        return pref.getInt(key, default)
    }

    override fun put(editor: SharedPreferences.Editor, key: String, value: Int) {
        editor.putInt(key, value)
    }
}