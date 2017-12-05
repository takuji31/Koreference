package jp.takuji31.koreference

import jp.takuji31.koreference.converter.ValueConverters
import jp.takuji31.koreference.property.*
import java.util.*

/**
 * Created by takuji on 2015/08/09.
 */
fun stringPreference(default: String = "", key: String? = null): KoreferencePropertyProvider<String?, String> {
    return object : KoreferencePropertyProvider<String?, String>(key, default){
        override fun createDelegate(key: String, defaultValue: String): KoreferenceProperty<String?, String> {
            return StringKoreferenceProperty.NonNull(defaultValue, key)
        }
    }
}

fun nullableStringPreference(default: String? = null, key: String? = null): KoreferencePropertyProvider<String?, String?> {
    return object : KoreferencePropertyProvider<String?, String?>(key, default){
        override fun createDelegate(key: String, defaultValue: String?): KoreferenceProperty<String?, String?> {
            return StringKoreferenceProperty.Nullable(defaultValue, key)
        }
    }
}

fun intPreference(default: Int = -1, key: String? = null): KoreferencePropertyProvider<Int, Int> {
    return object : KoreferencePropertyProvider<Int, Int>(key, default){
        override fun createDelegate(key: String, defaultValue: Int): KoreferenceProperty<Int, Int> {
            return IntKoreferenceProperty.Raw(defaultValue, key)
        }
    }
}

fun longPreference(default: Long = -1L, key: String? = null): KoreferencePropertyProvider<Long, Long> {
    return object : KoreferencePropertyProvider<Long, Long>(key, default){
        override fun createDelegate(key: String, defaultValue: Long): KoreferenceProperty<Long, Long> {
            return LongKoreferenceProperty.Raw(defaultValue, key)
        }
    }
}

fun floatPreference(default: Float = -1.0f, key: String? = null): KoreferencePropertyProvider<Float, Float> {
    return object : KoreferencePropertyProvider<Float, Float>(key, default){
        override fun createDelegate(key: String, defaultValue: Float): KoreferenceProperty<Float, Float> {
            return FloatKoreferenceProperty.Raw(defaultValue, key)
        }
    }
}

fun booleanPreference(default: Boolean = false, key: String? = null): KoreferencePropertyProvider<Boolean, Boolean> {
    return object : KoreferencePropertyProvider<Boolean, Boolean>(key, default){
        override fun createDelegate(key: String, defaultValue: Boolean): KoreferenceProperty<Boolean, Boolean> {
            return BooleanKoreferenceProperty.Raw(defaultValue, key)
        }
    }
}

fun stringSetPreference(default: Set<String> = HashSet<String>(), key: String? = null): KoreferencePropertyProvider<Set<String>?, Set<String>> {
    return object : KoreferencePropertyProvider<Set<String>?, Set<String>>(key, default){
        override fun createDelegate(key: String, defaultValue: Set<String>): KoreferenceProperty<Set<String>?, Set<String>> {
            return StringSetKoreferenceProperty.NonNull(defaultValue, key)
        }
    }
}

fun nullableStringSetPreference(default: Set<String>? = null, key: String? = null): KoreferencePropertyProvider<Set<String>?, Set<String>?> {
    return object : KoreferencePropertyProvider<Set<String>?, Set<String>?>(key, default){
        override fun createDelegate(key: String, defaultValue: Set<String>?): KoreferenceProperty<Set<String>?, Set<String>?> {
            return StringSetKoreferenceProperty.Nullable(defaultValue, key)
        }
    }
}
