package jp.takuji31.koreference

import jp.takuji31.koreference.converter.RawValueConverter
import jp.takuji31.koreference.type.*
import java.util.HashSet

/**
 * Created by takuji on 2015/08/09.
 */
public object Koreference {
    fun string(default: String = "", name: String? = null): KoreferenceDelegate<String, String> {
        return object : KoreferenceDelegate<String, String>(default, name), StringPreference, RawValueConverter<String> {}
    }

    fun nullableString(default: String? = null, name: String? = null): KoreferenceDelegate<String?, String?> {
        return object : KoreferenceDelegate<String?, String?>(default, name), NullableStringPreference, RawValueConverter<String?> {}
    }

    fun int(default: Int = -1, name: String? = null): KoreferenceDelegate<Int, Int> {
        return object : KoreferenceDelegate<Int, Int>(default, name), IntPreference, RawValueConverter<Int> {}
    }

    fun long(default: Long = -1L, name: String? = null): KoreferenceDelegate<Long, Long> {
        return object : KoreferenceDelegate<Long, Long>(default, name), LongPreference, RawValueConverter<Long> {}
    }

    fun float(default: Float = -1.0f, name: String? = null): KoreferenceDelegate<Float, Float> {
        return object : KoreferenceDelegate<Float, Float>(default, name), FloatPreference, RawValueConverter<Float> {}
    }

    fun boolean(default: Boolean = false, name: String? = null): KoreferenceDelegate<Boolean, Boolean> {
        return object : KoreferenceDelegate<Boolean, Boolean>(default, name), BooleanPreference, RawValueConverter<Boolean> {}
    }

    fun stringSet(default: Set<String> = HashSet<String>(), name: String? = null): KoreferenceDelegate<Set<String>, Set<String>> {
        return object : KoreferenceDelegate<Set<String>, Set<String>>(default, name), StringSetPreference, RawValueConverter<Set<String>> {}
    }

    fun nullableStringSet(default: Set<String>? = null, name: String? = null): KoreferenceDelegate<Set<String>?, Set<String>?> {
        return object : KoreferenceDelegate<Set<String>?, Set<String>?>(default, name), NullableStringSetPreference, RawValueConverter<Set<String>?> {}
    }
}