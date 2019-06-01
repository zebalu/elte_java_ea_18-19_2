package test;

import com.sun.istack.internal.Nullable;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;

public final class Assertions {

    private static final Logger LOGGER = Logger.getLogger(Assertions.class.getName());
    private static final String OK_MSG = "assertion passed: ";

    public static void fail(String message) {
        throw new AssertionError(message);
    }

    public static void assertThat(String message, Supplier<Boolean> predicate) {
        if (!predicate.get()) {
            fail(message);
        }
    }

    public static  <T> void assertThat(String message, T value, Predicate<T> predicate) {
        assertThat(message, () -> predicate.test(value));
    }

    public static void assertTrue(String message, boolean b) {
        assertThat(message, () -> b);
    }

    public static void assertFalse(String message, boolean b) {
        assertTrue(message, !b);
    }

    public static void assertEquals(String message, Object expected, Object actual) {
        assertThat(message, () -> Objects.equals(expected, actual));
    }

    public static void assertThrows(String message, @Nullable Class<? extends Throwable> exceptionClass, Runnable r) {
        try {
            r.run();
        } catch (Throwable t) {
            if (exceptionClass != null) {
                assertEquals("the thrown exception's class must equal " + exceptionClass,
                        t.getClass(), exceptionClass);
            }
            return;
        }
        fail(message);
    }

}
