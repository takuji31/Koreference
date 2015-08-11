package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public abstract class BooleanKoreference<T>(default: Boolean, name: String? = null) : KoreferenceDelegate<T, Boolean>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<Boolean> {
        return KoreferenceDelegate.booleanGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<Boolean> {
        return KoreferenceDelegate.booleanSetter
    }
}