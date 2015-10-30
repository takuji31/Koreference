package jp.takuji31.koreference

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by takuji on 2015/10/30.
 */
abstract class KoreferenceModel(pref: SharedPreferences) : SharedPreferences by pref {
    internal var transactionEditor: SharedPreferences.Editor? = null

    constructor(context: Context, name: String, mode: Int) : this(pref = context.getSharedPreferences(name, mode)) {
    }

    constructor(context: Context, name: String) : this(context = context, name = name, mode = Context.MODE_PRIVATE) {
    }

    fun transaction(f: KoreferenceModel.() -> TransactionResult) {
        transactionEditor = edit();
        val result = f()
        val editor = transactionEditor
        if (editor != null) {
            if (result == TransactionResult.COMMIT) {
                editor.commit()
            } else if (result == TransactionResult.APPLY) {
                editor.apply()
            }
            transactionEditor = null
        }
    }

    fun bulk(f: KoreferenceModel.() -> Unit) {
        transaction {
            f()
            TransactionResult.APPLY
        }
    }

    enum class TransactionResult {
        DISCARD, COMMIT, APPLY
    }
}