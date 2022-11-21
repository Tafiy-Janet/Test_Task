package api;

import helpers.PropertyReader;
import helpers.APISpecifications;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.File;

import static io.restassured.RestAssured.given;

public class RestTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/apiData.csv", numLinesToSkip = 1)
    public void validateJsonSchema(String endpoint, String schemaPass) {
        APISpecifications.installSpec(
                APISpecifications.requestSpec(PropertyReader.getApiURL()),
                APISpecifications.responseSpecOK200()
        );

        File filePath = new File(schemaPass).getAbsoluteFile();
        Assertions.assertTrue(filePath::isFile);

        given()
                .when().get(endpoint)
                .then()
                .assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(filePath));
    }
}

