package jp.takuji31.koreference;

import android.content.SharedPreferences
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.store.Store
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by takuji on 2015/08/08.
 */
abstract class KoreferenceProperty<P : Any?, M : Any?>(val default: M, val preferenceKey: String?, private val valueConverter: ValueConverter<P, M>) {

    abstract internal val store : Store<P>

    private val rawDefaultValue: P by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        valueConverter.toPreferenceValue(default)
    }

    fun get(sharedPreferences: SharedPreferences, key: String) : M {
        val value = store.get(sharedPreferences, key, rawDefaultValue)
        return valueConverter.toModelValue(value)
    }

    fun set(editor: SharedPreferences.Editor, key: String, value: M) {
        val preferenceValue = valueConverter.toPreferenceValue(value)
        store.put(editor, key, preferenceValue)
    }
}
