package hexlet.code.schema;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestStringSchema {
    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.minLength(4).isValid(null)).isTrue();

//        assertThat(schema.isValid(5)).isFalse();

        schema.required();
        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();

        assertThat(schema.isValid("what does the fox say")).isTrue();
//        assertThat(schema.isValid(5)).isFalse();

        assertThat(schema.isValid("hexlet")).isTrue();

        assertThat(schema.isValid("what does the fox say")).isTrue();
        assertThat(schema.isValid("wha")).isFalse();

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue();
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse();
    }
}
