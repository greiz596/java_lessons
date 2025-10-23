package diplom.task_2;

import io.restassured.RestAssured;
import org.junit.Before;

import static diplom.task_2.utils.constants.Api.*;

public class BaseTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
    }

}
