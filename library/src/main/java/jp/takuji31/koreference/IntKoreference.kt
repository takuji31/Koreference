package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public abstract class IntKoreference<T>(default:Int, name:String? = null) : KoreferenceDelegate<T, Int>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<Int> {
        return KoreferenceDelegate.intGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<Int> {
        return KoreferenceDelegate.intSetter
    }
}