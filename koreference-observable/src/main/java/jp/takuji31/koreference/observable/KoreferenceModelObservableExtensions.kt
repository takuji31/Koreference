package jp.takuji31.koreference.observable

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceModel
import jp.takuji31.koreference.KoreferenceProperty
import kotlin.reflect.KProperty0
import kotlin.reflect.KProperty1
import kotlin.reflect.full.instanceParameter

private fun <T: KoreferenceObservableModel> ensurePropertyIsMine(receiver :T, property: KProperty0<*>) {
    if (receiver.javaClass.kotlin != property.instanceParameter?.type?.classifier) {
        throw IllegalArgumentException("$property is not property of ${receiver.javaClass.kotlin.qualifiedName}")
    }
}

fun <T : KoreferenceObservableModel, R> T.getValueAsSingle(property: KProperty0<R>): Single<R> {
    getKoreferencePropertyKey(property)
    return Single.fromCallable {
        property.get()
    }
}

fun <T : KoreferenceObservableModel, R> T.observe(property: KProperty0<R>): Observable<R> {
    val key = getKoreferencePropertyKey(property)
    return Observable.create { emitter ->
        val initialiValue = property.get()

        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, changedKey ->
            if (changedKey == key) {
                emitter.onNext(property.get())
            }
        }
        emitter.onNext(initialiValue)
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
}

fun <P, M> KoreferenceProperty<P, M>.withObservableSupport(): KoreferenceObservablePropertyProvider<P, M>
        = KoreferenceObservablePropertyProvider(this)
