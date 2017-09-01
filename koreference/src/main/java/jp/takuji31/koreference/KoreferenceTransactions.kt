package jp.takuji31.koreference

fun <T : KoreferenceModel> T.bulk(f: T.() -> Unit) {
    if (transactionEditor != null) {
        throw IllegalStateException("Nested transaction is not supported.")
    }
    val editor = edit()
    transactionEditor = editor
    f()
    editor.apply()
    transactionEditor = null
}