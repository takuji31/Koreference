package jp.takuji31.koreference.observable

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import jp.takuji31.koreference.test.TestKoreferenceModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import kotlin.properties.Delegates
import kotlin.test.assertFailsWith

@RunWith(RobolectricTestRunner::class)
class KoreferenceModelObservableTest {

    var pref: SharedPreferences by Delegates.notNull()

    @Before
    fun setup() {
        pref = InstrumentationRegistry.getTargetContext().getSharedPreferences("test", Context.MODE_PRIVATE)
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

        val testSubscriber = model.getValueAsSingle(TestKoreferenceModel::stringValue).test()

        testSubscriber.assertValue("this is observed value")

        assertFailsWith<IllegalArgumentException> {
            model.getValueAsSingle(TestKoreferenceModel::noKoreferenceProperty).test()
        }
    }

    @Test
    fun observe() {
        val model = TestKoreferenceModel(pref)
        model.stringValue = "firstValue"

        val testSubscriber = model.observe(TestKoreferenceModel::stringValue).test()

        model.stringValue = "secondValue"

        testSubscriber.awaitCount(2)

        model.stringValue = "thirdValue"

        testSubscriber.awaitCount(3)

        testSubscriber.assertValues("firstValue", "secondValue", "thirdValue")

        assertFailsWith<IllegalArgumentException> {
            model.observe(TestKoreferenceModel::noKoreferenceProperty).test()
        }
    }
}
