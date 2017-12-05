package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
interface Preference<T : Any?> {
    operator fun get(pref: SharedPreferences, key: String, default: T): T
    fun put(editor: SharedPreferences.Editor, key: String, value: T)
}