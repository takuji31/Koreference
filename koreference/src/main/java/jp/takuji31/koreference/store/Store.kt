package jp.takuji31.koreference.store

import android.content.SharedPreferences

interface Store<T : Any?> {
    fun get(pref: SharedPreferences, key: String, defaultValue: T): T
    fun put(editor: SharedPreferences.Editor, key: String, value: T)
}