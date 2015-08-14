package jp.takuji31.koreference.converter

/**
 * Created by takuji on 2015/08/14.
 */
public interface ValueConverter<PrefValue : Any?, ModelValue : Any?> {
    fun toPreferenceValue(value: ModelValue): PrefValue
    fun toModelValue(value: PrefValue): ModelValue
}