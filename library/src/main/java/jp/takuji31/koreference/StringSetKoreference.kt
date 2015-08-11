package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public abstract class StringSetKoreference<T>(default: Set<String>, name: String? = null) : KoreferenceDelegate<T, Set<String>>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<Set<String>> {
        return KoreferenceDelegate.stringSetGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<Set<String>> {
        return KoreferenceDelegate.stringSetSetter
    }
}