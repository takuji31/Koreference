package jp.takuji31.koreference;

import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty

/**
 * Created by takuji on 2015/08/08.
 */
public abstract class KoreferenceDelegate<ModelValue : Any, PrefValue : Any>(val default: PrefValue, val name: String? = null) : ReadWriteProperty<SharedPreferences, ModelValue> {

    override fun get(thisRef: SharedPreferences, desc: PropertyMetadata): ModelValue {
        val getter = getPrefGetter()
        return getModelValue(getter.getValue(thisRef, name ?: desc.name, default))
    }

    override fun set(thisRef: SharedPreferences, desc: PropertyMetadata, value: ModelValue) {
        val editor = thisRef.edit()
        val setter = getPrefSetter()
        setter.setValue(editor, name ?: desc.name, getPreferenceValue(value))
        editor.apply()
    }

    abstract fun getPrefGetter(): PrefGetter<PrefValue>
    abstract fun getPrefSetter(): PrefSetter<PrefValue>

    abstract fun getModelValue(prefValue: PrefValue): ModelValue
    abstract fun getPreferenceValue(value: ModelValue): PrefValue

    public interface PrefGetter<ValType> {
        fun getValue(pref: SharedPreferences, name: String, default: ValType): ValType
    }

    public interface PrefSetter<ValType> {
        fun setValue(editor: SharedPreferences.Editor, name: String, value: ValType): Unit
    }

    companion object KoreferenceDelegate {
        protected val stringGetter: PrefGetter<String> = object : PrefGetter<String> {
            override fun getValue(pref: SharedPreferences, name: String, default: String): String {
                return pref.getString(name, default)
            }
        }
        protected val intGetter: PrefGetter<Int> = object : PrefGetter<Int> {
            override fun getValue(pref: SharedPreferences, name: String, default: Int): Int {
                return pref.getInt(name, default)
            }
        }
        protected val longGetter: PrefGetter<Long> = object : PrefGetter<Long> {
            override fun getValue(pref: SharedPreferences, name: String, default: Long): Long {
                return pref.getLong(name, default)
            }
        }
        protected val booleanGetter: PrefGetter<Boolean> = object : PrefGetter<Boolean> {
            override fun getValue(pref: SharedPreferences, name: String, default: Boolean): Boolean {
                return pref.getBoolean(name, default)
            }
        }
        protected val floatGetter: PrefGetter<Float> = object : PrefGetter<Float> {
            override fun getValue(pref: SharedPreferences, name: String, default: Float): Float {
                return pref.getFloat(name, default)
            }
        }
        protected val stringSetGetter: PrefGetter<Set<String>> = object : PrefGetter<Set<String>> {
            override fun getValue(pref: SharedPreferences, name: String, default: Set<String>): Set<String> {
                return pref.getStringSet(name, default)
            }
        }
        protected val stringSetter: PrefSetter<String> = object : PrefSetter<String> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: String) {
                editor.putString(name, value)
            }
        }
        protected val intSetter: PrefSetter<Int> = object : PrefSetter<Int> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: Int) {
                editor.putInt(name, value)
            }
        }
        protected val longSetter: PrefSetter<Long> = object : PrefSetter<Long> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: Long) {
                editor.putLong(name, value)
            }
        }
        protected val booleanSetter: PrefSetter<Boolean> = object : PrefSetter<Boolean> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: Boolean) {
                editor.putBoolean(name, value)
            }
        }
        protected val floatSetter: PrefSetter<Float> = object : PrefSetter<Float> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: Float) {
                editor.putFloat(name, value)
            }
        }
        protected val stringSetSetter: PrefSetter<Set<String>> = object : PrefSetter<Set<String>> {
            override fun setValue(editor: SharedPreferences.Editor, name: String, value: Set<String>) {
                editor.putStringSet(name, value)
            }
        }
    }

}