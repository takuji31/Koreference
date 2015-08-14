package jp.takuji31.koreference.type

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/14.
 */
public interface Preference<T : Any?> {
    fun get(pref: SharedPreferences, key: String, default: T): T
    fun set(editor : SharedPreferences.Editor, key: String, value: T)
}