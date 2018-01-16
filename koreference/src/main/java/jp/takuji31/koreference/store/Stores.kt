package jp.takuji31.koreference.store

import android.content.SharedPreferences

internal object Stores {
    val Boolean = object : Store<Boolean> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: Boolean): Boolean {
            return pref.getBoolean(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: Boolean) {
            editor.putBoolean(key, value)
        }
    }

    val Float = object : Store<Float> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: Float): Float {
            return pref.getFloat(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: Float) {
            editor.putFloat(key, value)
        }
    }

    val Int = object : Store<Int> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: Int): Int {
            return pref.getInt(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: Int) {
            editor.putInt(key, value)
        }
    }

    val Long = object : Store<Long> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: Long): Long {
            return pref.getLong(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: Long) {
            editor.putLong(key, value)
        }
    }

    val String = object : Store<String?> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: String?): String? {
            return pref.getString(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: String?) {
            editor.putString(key, value)
        }
    }

    val StringSet = object : Store<Set<String>?> {
        override fun get(pref: SharedPreferences, key: String, defaultValue: Set<String>?): Set<String>? {
            return pref.getStringSet(key, defaultValue)
        }

        override fun put(editor: SharedPreferences.Editor, key: String, value: Set<String>?) {
            editor.putStringSet(key, value)
        }
    }

}