package jp.takuji31.koreference.observable

import android.content.SharedPreferences
import io.reactivex.Observable
import io.reactivex.Single
import jp.takuji31.koreference.KoreferenceProperty
import jp.takuji31.koreference.property.KoreferencePropertyProvider
import kotlin.reflect.KProperty0

fun <T : KoreferenceObservableModel, R> T.getValueAsSingle(property: KProperty0<R>): Single<R> {
    getKoreferencePropertyKey(property)
    return Single.fromCallable {
        property.get()
    }
}

fun <T : KoreferenceObservableModel, R> T.observe(property: KProperty0<R>): Observable<R> {
    val key = getKoreferencePropertyKey(property)
    return Observable.create { emitter ->
        val initialValue = property.get()

        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, changedKey ->
            if (changedKey == key) {
                emitter.onNext(property.get())
            }
        }
        emitter.onNext(initialValue)
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        emitter.setCancellable {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener)
        }
    }
}

fun <P, M> KoreferenceProperty<P, M>.enableObservableSupport(): KoreferencePropertyProvider<P, M>
        = KoreferenceObservablePropertyProvider(this)
