package jp.takuji31.koreference;

import android.content.SharedPreferences
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.type.Preference
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by takuji on 2015/08/08.
 */
public abstract class KoreferenceProperty<M : Any?, P : Any?>(val default: M, val name: String? = null) : ReadWriteProperty<SharedPreferences, M>, Preference<P>, ValueConverter<P, M> {

    private val rawDefaultValue: P by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        toPreferenceValue(default)
    }

    override fun getValue(thisRef: SharedPreferences, property: KProperty<*>): M {
        val value = get(thisRef, name ?: property.name, rawDefaultValue)
        return toModelValue(value)
    }

    override fun setValue(thisRef: SharedPreferences, property: KProperty<*>, value: M) {
        val editor = thisRef.edit()
        set(editor, name ?: property.name, toPreferenceValue(value))
        editor.apply()
    }

}
