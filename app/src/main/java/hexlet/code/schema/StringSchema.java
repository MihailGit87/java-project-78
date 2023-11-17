package hexlet.code.schema;

public class StringSchema {
    private boolean isRequired;
    private Integer minLength;
    private String containsSubstring;

    public StringSchema required() {
        this.isRequired = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.containsSubstring = substring;
        return this;
    }

    public boolean isValid(String data) {
        if (isRequired && (data == null || data.isEmpty())) {
            return false;
        }

        if (minLength != null && data.length() < minLength) {
            return false;
        }

        if (containsSubstring != null && ! data.contains(containsSubstring)) {
            return false;
        }

        return true;
    }
}
