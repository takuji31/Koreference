package jp.takuji31.koreference.store

import android.content.SharedPreferences

interface Store<T : Any?> {
    fun get(pref: SharedPreferences, key: String, defaultValue: T): T
    fun put(editor: SharedPreferences.Editor, key: String, value: T)

    abstract class SupportsNonNull<T> : Store<T?> {
        fun toNonnullStore() : Store<T> {
            val original = this
            return object : Store<T> {
                override fun get(pref: SharedPreferences, key: String, defaultValue: T): T {
                    return original.get(pref, key, defaultValue) ?: defaultValue
                }

                override fun put(editor: SharedPreferences.Editor, key: String, value: T) {
                    original.put(editor, key, value)
                }
            }
        }
    }

}