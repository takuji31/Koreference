package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public abstract class FloatKoreference<T>(default: Float, name: String? = null) : KoreferenceDelegate<T, Float>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<Float> {
        return KoreferenceDelegate.floatGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<Float> {
        return KoreferenceDelegate.floatSetter
    }
}