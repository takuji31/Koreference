package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2015/08/14.
 */
interface ValueConverter<P : Any?, ModelValue : Any?> {
    fun toPreferenceValue(value: ModelValue): P
    fun toModelValue(value: P): ModelValue

    class Raw<T: Any?> : ValueConverter<T, T> {
        override fun toPreferenceValue(value: T): T {
            return value
        }

        override fun toModelValue(value: T): T {
            return value
        }
    }

    class NonNull<T: Any>(private val defaultValue: T) : ValueConverter<T?, T> {
        override fun toPreferenceValue(value: T): T? {
            return value
        }

        override fun toModelValue(value: T?): T {
            return value ?: defaultValue
        }
    }
}