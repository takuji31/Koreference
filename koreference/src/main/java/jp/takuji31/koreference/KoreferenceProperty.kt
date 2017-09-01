package jp.takuji31.koreference;

import android.content.SharedPreferences
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.type.Preference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by takuji on 2015/08/08.
 */
abstract class KoreferenceProperty<M : Any?, P : Any?>(val default: M, val name: String? = null) : ReadWriteProperty<KoreferenceModel, M>, Preference<P>, ValueConverter<P, M> {

    private val rawDefaultValue: P by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        toPreferenceValue(default)
    }

    override fun getValue(thisRef: KoreferenceModel, property: KProperty<*>): M {
        val value = get(thisRef.sharedPreferences, name ?: property.name, rawDefaultValue)
        return toModelValue(value)
    }

    override fun setValue(thisRef: KoreferenceModel, property: KProperty<*>, value: M) {
        val transactionEditor = thisRef.transactionEditor
        val preferenceValue = toPreferenceValue(value)

        transactionEditor?.let {
            set(it, name ?: property.name, preferenceValue)
            return
        }

        val editor: SharedPreferences.Editor = thisRef.sharedPreferences.edit()
        set(editor, name ?: property.name, preferenceValue)
        editor.apply()
    }

}
