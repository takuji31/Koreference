package jp.takuji31.koreference

/**
 * Created by takuji on 2015/08/09.
 */
public abstract  class LongKoreference<T>(default:Long, name:String?=null) : KoreferenceDelegate<T, Long>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<Long> {
        return KoreferenceDelegate.longGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<Long> {
        return KoreferenceDelegate.longSetter
    }
}