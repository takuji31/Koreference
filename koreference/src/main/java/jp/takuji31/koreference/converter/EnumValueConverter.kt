package jp.takuji31.koreference.converter

class NullableEnumValueConverter<T: Enum<T>>(private val decoder: (String?) -> T?) : ValueConverter<String?, T?> {
    override fun toPreferenceValue(value: T?): String? {
        return value?.name
    }

    override fun toModelValue(value: String?): T? {
        return decoder(value)
    }
}
class NonNullEnumValueConverter<T: Enum<T>>(private val decoder: (String) -> T) : ValueConverter<String, T> {
    override fun toPreferenceValue(value: T): String {
        return value.name
    }

    override fun toModelValue(value: String): T {
        return decoder(value)
    }
}