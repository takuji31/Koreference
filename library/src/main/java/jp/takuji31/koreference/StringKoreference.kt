package jp.takuji31.koreference

import android.content.SharedPreferences

/**
 * Created by takuji on 2015/08/09.
 */
public abstract  class StringKoreference<T>(default: String, name: String? = null) : KoreferenceDelegate<T, String>(default, name) {
    override fun getPrefGetter(): KoreferenceDelegate.PrefGetter<String> {
        return KoreferenceDelegate.stringGetter
    }

    override fun getPrefSetter(): KoreferenceDelegate.PrefSetter<String> {
        return KoreferenceDelegate.stringSetter
    }
}