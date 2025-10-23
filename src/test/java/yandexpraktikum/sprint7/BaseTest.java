package sprint7;

import io.restassured.RestAssured;
import org.junit.Before;
import static sprint7.utils.constants.Api.*;
import static sprint7.utils.constants.Courier.*;
import static sprint7.utils.constants.Constants.*;

public class BaseTest {
    @Before
    public void setUp() {
        RestAssured.baseURI = BASE_URL;
        STEPS.deleteCourierById(DEFUALT_LOGIN_COURIER_DATA);
    }

}