package jp.takuji31.koreference;

import android.content.SharedPreferences
import jp.takuji31.koreference.converter.ValueConverter
import jp.takuji31.koreference.type.Preference
import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty

/**
 * Created by takuji on 2015/08/08.
 */
public abstract class KoreferenceDelegate<M : Any?, P : Any?>(val default: M, val name: String? = null) : ReadWriteProperty<SharedPreferences, M>, Preference<P>, ValueConverter<P, M> {

    val rawDefaultValue: P by Delegates.lazy {
        toPreferenceValue(default)
    }

    override fun get(thisRef: SharedPreferences, desc: PropertyMetadata): M {
        val value = get(thisRef, name ?: desc.name, rawDefaultValue)
        return toModelValue(value)
    }

    override fun set(thisRef: SharedPreferences, desc: PropertyMetadata, value: M) {
        val editor = thisRef.edit()
        set(editor, name ?: desc.name, toPreferenceValue(value))
        editor.apply()
    }

}
