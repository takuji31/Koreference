package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public object Koreference {
    public fun String(default: String, name: String? = null): KoreferenceDelegate<String, String> {
        return object : StringKoreference<String>(default, name) {
            override fun getModelValue(prefValue: String): String {
                return prefValue
            }

            override fun getPreferenceValue(value: String): String {
                return value
            }
        }
    }

    public fun Int(default: Int, name: String? = null): KoreferenceDelegate<Int, Int> {
        return object : IntKoreference<Int>(default, name) {
            override fun getModelValue(prefValue: Int): Int {
                return prefValue
            }

            override fun getPreferenceValue(value: Int): Int {
                return value
            }
        }
    }

    public fun Float(default: Float, name: String? = null): KoreferenceDelegate<Float, Float> {
        return object : FloatKoreference<Float>(default, name) {
            override fun getModelValue(prefValue: Float): Float {
                return prefValue
            }

            override fun getPreferenceValue(value: Float): Float {
                return value
            }
        }
    }

    public fun Long(default: Long, name: String? = null): KoreferenceDelegate<Long, Long> {
        return object : LongKoreference<Long>(default, name) {
            override fun getModelValue(prefValue: Long): Long {
                return prefValue
            }

            override fun getPreferenceValue(value: Long): Long {
                return value
            }
        }
    }

    public fun Boolean(default: Boolean, name: String? = null): KoreferenceDelegate<Boolean, Boolean> {
        return object : BooleanKoreference<Boolean>(default, name) {
            override fun getModelValue(prefValue: Boolean): Boolean {
                return prefValue
            }

            override fun getPreferenceValue(value: Boolean): Boolean {
                return value
            }
        }
    }

    public fun StringSet(default: Set<String>, name: String? = null): KoreferenceDelegate<Set<String>, Set<String>> {
        return object : StringSetKoreference<Set<String>>(default, name) {
            override fun getModelValue(prefValue: Set<String>): Set<String> {
                return prefValue
            }

            override fun getPreferenceValue(value: Set<String>): Set<String> {
                return value
            }
        }
    }
}