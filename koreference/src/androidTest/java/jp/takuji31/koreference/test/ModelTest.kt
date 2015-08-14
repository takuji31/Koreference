package jp.takuji31.koreference.test

import android.content.Context
import android.content.SharedPreferences
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.test.AndroidTestCase
import jp.takuji31.koreference
import org.junit
import org.junit.runner.RunWith
import java.util.*
import kotlin.properties.Delegates
import kotlin.test.*

/**
 * Created by takuji on 2015/08/10.
 */
RunWith(AndroidJUnit4::class)
public class ModelTest {
    val context: Context by Delegates.lazy {
        InstrumentationRegistry.getTargetContext()
    }

    val pref: SharedPreferences by Delegates.lazy {
        context.getSharedPreferences("test", Context.MODE_PRIVATE)
    }

    junit.Before
    fun setup() {
        pref.edit().clear().commit()
    }

    junit.After
    fun teardown() {
        pref.edit().clear().commit()
    }

    junit.Test
    fun testDefaultValue() {
        val model = TestPreferenceModel(pref = pref)
        assertEquals(model.stringValue, "default value", "String default value")
        assertEquals(model.intValue, 256, "Int default value")
        assertEquals(model.longValue, 256L, "Long default value")
        assertEquals(model.floatValue, 12.34f, "Float default value")
        assertEquals(model.boolValue, true, "Boolean default value")
        assertEquals(model.stringSetValue, setOf<String>(), "String set default value")
    }

    junit.Test
    fun testSetValue() {
        val model = TestPreferenceModel(pref = pref)

        model.stringValue = "new value"
        model.intValue = 12345
        model.longValue = 12345678901234L
        model.floatValue = 1234.5678f
        model.boolValue = false
        model.stringSetValue = setOf("foo", "bar")

        assertEquals(model.stringValue, "new value", "String new value")
        assertEquals(model.intValue, 12345, "Int new value")
        assertEquals(model.longValue, 12345678901234L, "Long new value")
        assertEquals(model.floatValue, 1234.5678f, "Float new value")
        assertEquals(model.boolValue, false, "Boolean new value")
        assertEquals(model.stringSetValue, setOf("foo", "bar"), "String set default value")
    }

    junit.Test
    fun testNullable() {
        val model = TestNullablePreferenceModel(pref = pref)

        assertNull(model.stringValue, "Nullable string default value")
        assertNull(model.stringSetValue, "Nullable string set default value")

        model.stringValue = "new value"
        model.stringSetValue  = setOf("foo", "bar")

        assertEquals(model.stringValue!!, "new value", "Nullable string new value")
        assertEquals(model.stringSetValue!!, setOf("foo", "bar"), "Nullable string set new value")

    }
}
