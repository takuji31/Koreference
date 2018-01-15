package jp.takuji31.koreference.test

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Created by takuji on 2015/08/10.
 */
@RunWith(RobolectricTestRunner::class)
class SharedPreferencesTest {
    val context: Context by lazy() {
        RuntimeEnvironment.application
    }

    val pref: SharedPreferences by lazy() {
        context.getSharedPreferences("test", Context.MODE_PRIVATE)
    }

    @Before
    fun setup() {
        pref.edit().clear().apply()
    }

    @After
    fun teardown() {
        pref.edit().clear().apply()
    }

    @Test
    fun testDefaultValue() {
        val model = TestPreferenceModel(pref = pref)
        assertEquals(model.stringValue, "default value", "String default value")
        assertEquals(model.intValue, 256, "Int default value")
        assertEquals(model.longValue, 256L, "Long default value")
        assertEquals(model.floatValue, 12.34f, "Float default value")
        assertEquals(model.boolValue, true, "Boolean default value")
        assertEquals(model.stringSetValue, setOf<String>(), "String set default value")
        assertEquals(model.enumValue, TestEnum.FUGA, "Enum default value")
    }

    @Test
    fun testSetValue() {
        val model = TestPreferenceModel(pref = pref)

        model.stringValue = "new value"
        model.intValue = 12345
        model.longValue = 12345678901234L
        model.floatValue = 1234.5678f
        model.boolValue = false
        model.stringSetValue = setOf("foo", "bar")
        model.enumValue = TestEnum.PIYO

        assertEquals(model.stringValue, "new value", "String new value")
        assertEquals(model.intValue, 12345, "Int new value")
        assertEquals(model.longValue, 12345678901234L, "Long new value")
        assertEquals(model.floatValue, 1234.5678f, "Float new value")
        assertEquals(model.boolValue, false, "Boolean new value")
        assertEquals(model.stringSetValue, setOf("foo", "bar"), "String set default value")
        assertEquals(model.enumValue, TestEnum.PIYO, "Enum new value")
    }

    @Test
    fun testNullable() {
        val model = TestNullablePreferenceModel(pref = pref)

        assertNull(model.stringValue, "Nullable string default value")
        assertNull(model.stringSetValue, "Nullable string set default value")
        assertNull(model.enumValue, "Nullable enum default value")

        model.stringValue = "new value"
        model.stringSetValue = setOf("foo", "bar")
        model.enumValue = TestEnum.HOGE

        assertEquals(model.stringValue!!, "new value", "Nullable string new value")
        assertEquals(model.stringSetValue!!, setOf("foo", "bar"), "Nullable string set new value")
        assertEquals(model.enumValue!!, TestEnum.HOGE, "Nullable enum set new value")

    }

    @Test
    fun testKeys() {
        val model = TestPreferenceModel(pref = pref)

        val nextValue = "next value!!!"
        model.stringValue = nextValue

        assertEquals(pref.getString("stringValue", ""), nextValue, "Correct key value")

        val customKeyValue = "This is custom key value"
        model.customKeyValue = customKeyValue

        assertEquals(pref.getString("hogeKey", ""), customKeyValue, "Correct custom key value")
    }
}
