### CI and linter status:
[![Actions Status](https://github.com/MihailGit87/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/MihailGit87/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/0a5a77160ff6af355aab/maintainability)](https://codeclimate.com/github/MihailGit87/java-project-78/maintainability)
[![Java-CI](https://github.com/MihailGit87/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/MihailGit87/java-project-78/actions/workflows/main.yml)
[![Test Coverage](https://api.codeclimate.com/v1/badges/0a5a77160ff6af355aab/test_coverage)](https://codeclimate.com/github/MihailGit87/java-project-78/test_coverage)

### Data validator

Data validator is a library for checking the correctness of the entered data: String, Number, Map. The library has the methods to work with data:
- String:
  - _required()_ - checking whether a string is not _null_ or empty,
  - _minLength()_ - checking if a string is more or equals given length,
  - _contains()_ - checking if a string contains a given substring.
- Number:
  - _required()_ - checking whether a number is not _null_,
  - _positive()_ - checking if a number is positive,
  - _range()_ - checking whether a number is in the range.
- Map:
  - _required()_ - checking whether a map is not _null_,
  - _sizeof()_ - checking whether a map is equal to a given size,
  - _shape()_ - allows to describe validation for inserted objects of Map by keys.
 
## Usage example
```java
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

// String validation
StringSchema stringSchema = v.string();

stringSchema.isValid(""); // true
stringSchema.isValid(null); // true

stringSchema.required().minLength(5).contains("what");
stringSchema.isValid("what does the fox say"); // true
stringSchema.isValid("The fox says"); // false

// Number validation
NumberSchema numberSchema = v.number();

numberSchema.isValid(null); // true
numberSchema.positive().isValid(null); // true

schema.required().range(5, 10);

schema.isValid(-10); // false
schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false

// Map validation
Map<String, BaseSchema> schemas = new HashMap<>();

schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());

schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false
