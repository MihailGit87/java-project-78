package hexlet.code;

import hexlet.code.schema.NumberSchema;
import hexlet.code.schema.StringSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    private Validator validator;

    @BeforeEach
    final void setUp() {
        validator = new Validator();
    }

    @Test
    void testStringSchema() {
        StringSchema schema = validator.string();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid("Hexlet"));
        assertFalse(schema.isValid(5));

        schema.required();

        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));
        assertTrue(schema.isValid("Hexlet"));

        schema.minLength(5);

        assertTrue(schema.isValid("Hexlet"));
        assertFalse(schema.isValid("Hex"));

        schema.contains("Hex");
        assertTrue(schema.isValid("Hexlet"));

        schema.contains("xle");
        assertTrue(schema.isValid("Hexlet"));

        schema.contains("hello");
        assertFalse(schema.isValid("Hexlet"));
    }

    @Test
    void testNumberSchema() {
        NumberSchema schema = validator.number();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertTrue(schema.isValid(-77));
        assertTrue(schema.isValid(0));
        assertFalse(schema.isValid("Hexlet"));

        schema.positive();

        assertTrue(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertFalse(schema.isValid(-77));
        assertFalse(schema.isValid(0));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(77));
        assertFalse(schema.isValid(-77));
        assertFalse(schema.isValid(0));

        schema.range(50, 100);

        assertTrue(schema.isValid(77));
        assertTrue(schema.isValid(50));
        assertTrue(schema.isValid(100));
        assertFalse(schema.isValid(25));
        assertFalse(schema.isValid(125));
    }
}
