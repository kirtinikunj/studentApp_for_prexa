package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/*
 *  Created by Jay
 */
public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response=given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo() {
        Response response=given()
                .pathParam("id",4)
                .when()
                .get("/{id}");//becoz allready we declared id variable in pathParam so in curly bracket
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStudentWithParameter() {
        //students with computer science, 2 students
        Map<String,Object> qParams =new HashMap<>();
        qParams.put("programme","Computer Science");
        qParams.put("limit",2);
        Response response=given()
//                .queryParam("programme","Computer Science")
//                .queryParam("limit",2)
                .queryParams(qParams)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
