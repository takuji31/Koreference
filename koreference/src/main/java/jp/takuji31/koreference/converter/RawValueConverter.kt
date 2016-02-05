package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2015/08/14.
 */
interface RawValueConverter<T> : ValueConverter<T, T> {
    override fun toPreferenceValue(value: T): T {
        return value
    }

    override fun toModelValue(value: T): T {
        return value
    }
}