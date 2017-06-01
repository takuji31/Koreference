package jp.takuji31.koreference

/**
 * Created by takuji on 2015/10/30.
 */
fun <T : KoreferenceModel> T.transaction(f: T.() -> TransactionResult) {
    transactionEditor = edit()
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

fun <T : KoreferenceModel> T.bulk(f: T.() -> Unit) {
    transaction {
        f()
        TransactionResult.APPLY
    }
}

val KoreferenceModel.transactionDiscard: TransactionResult
    get() = TransactionResult.DISCARD

val KoreferenceModel.transactionCommit: TransactionResult
    get() = TransactionResult.COMMIT

val KoreferenceModel.transactionApply: TransactionResult
    get() = TransactionResult.APPLY

enum class TransactionResult {
    DISCARD, COMMIT, APPLY
}
