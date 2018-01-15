package jp.takuji31.koreference;

import android.content.SharedPreferences
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.store.Store
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by takuji on 2015/08/08.
 */
abstract class KoreferenceProperty<P : Any?, M : Any?>(val default: M, val preferenceKey: String?, private val valueConverter: ValueConverter<P, M>) : ReadWriteProperty<KoreferenceModel, M> {

    abstract val store : Store<P>

    private val rawDefaultValue: P by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        valueConverter.toPreferenceValue(default)
    }

    override fun getValue(thisRef: KoreferenceModel, property: KProperty<*>): M {
        val value = store.get(thisRef.sharedPreferences, preferenceKey ?: property.name, rawDefaultValue)
        return valueConverter.toModelValue(value)
    }

    override fun setValue(thisRef: KoreferenceModel, property: KProperty<*>, value: M) {
        val transactionEditor = thisRef.transactionEditor
        val preferenceValue = valueConverter.toPreferenceValue(value)

        transactionEditor?.let {
            store.put(it, preferenceKey ?: property.name, preferenceValue)
            return
        }

        val editor: SharedPreferences.Editor = thisRef.sharedPreferences.edit()
        store.put(editor, preferenceKey ?: property.name, preferenceValue)
        editor.apply()
    }

}
