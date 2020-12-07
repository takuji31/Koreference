package jp.takuji31.koreference.observable

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import jp.takuji31.koreference.test.TestKoreferenceModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RuntimeEnvironment
import kotlin.properties.Delegates
import kotlin.test.assertFailsWith

@RunWith(AndroidJUnit4::class)
class KoreferenceModelObservableTest {

    var pref: SharedPreferences by Delegates.notNull()

    @Before
    fun setup() {
        pref = ApplicationProvider.getApplicationContext<Context>().getSharedPreferences("test", Context.MODE_PRIVATE)
        pref.edit().clear().apply()
    }

    @After
    fun teardown() {
        pref.edit().clear().apply()
    }


    @Test
    fun getValueAsSingle() {
        val model = TestKoreferenceModel(pref)
        model.stringValue = "this is observed value"

        val testSubscriber = model.getValueAsSingle(model::stringValue).test()

        testSubscriber.assertValue("this is observed value")

        assertFailsWith<IllegalArgumentException> {
            model.getValueAsSingle(model::noKoreferenceProperty).test()
        }
    }

    @Test
    fun observe() {
        val model = TestKoreferenceModel(pref)
        model.stringValue = "firstValue"

        val testSubscriber = model.observe(model::stringValue).test()

        model.stringValue = "secondValue"

        testSubscriber.awaitCount(2)

        model.stringValue = "thirdValue"

        testSubscriber.awaitCount(3)

        testSubscriber.assertValues("firstValue", "secondValue", "thirdValue")

        assertFailsWith<IllegalArgumentException> {
            model.observe(model::noKoreferenceProperty).test()
        }
    }

    @Test
    fun privateProperty() {
        val model = TestKoreferenceModel(pref)
        model.putPrivateStringValue(value = "firstValue")

        val testSubscriber = model.privateStringValueObservable.test()

        testSubscriber.assertValue("firstValue")

        model.putPrivateStringValue(value = "secondValue")

        testSubscriber.assertValues("firstValue", "secondValue")

        val testSingleSubscriber = model.privateStringValueSingle.test()

        testSingleSubscriber.assertValue("secondValue")
    }
}
