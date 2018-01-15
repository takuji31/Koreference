package jp.takuji31.koreference.property

import android.content.SharedPreferences
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * Created by takuji on 2018/01/16.
 */
class KoreferenceReadWriteProperty<in R : KoreferenceModel, M>(
        private val koreferenceProperty: KoreferenceProperty<*, M>,
        private val key: String
): ReadWriteProperty<R, M> {
    override fun getValue(thisRef: R, property: KProperty<*>): M {
        return koreferenceProperty.get(thisRef.sharedPreferences, key)
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: M) {
        val transactionEditor = thisRef.transactionEditor

        transactionEditor?.let {
            koreferenceProperty.set(it, key, value)
            return
        }

        val editor: SharedPreferences.Editor = thisRef.sharedPreferences.edit()
        koreferenceProperty.set(editor, key, value)
        editor.apply()
    }
}