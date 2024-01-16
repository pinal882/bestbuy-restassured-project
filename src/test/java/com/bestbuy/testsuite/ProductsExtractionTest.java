package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest  {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port= 3030;
        response = given()
                .when()
                .get("products")
                .then().statusCode(200);
    }
    //21. Extract the limit
    @Test
    public void test001(){
        int limit = response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }
    //22. Extract the total
    @Test
    public void test002(){
        int total = response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total  is : " + total);
        System.out.println("------------------End of Test---------------------------");

    }
    //23. Extract the name of 5th product
    @Test
    public void test003() {
        String productName = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of the 5th product  is : " + productName );
        System.out.println("------------------End of Test---------------------------");
    }
    //24. Extract the names of all the products
    @Test
    public void test004() {
        List<String > nameOfProduct = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all product is : " + nameOfProduct );
        System.out.println("------------------End of Test---------------------------");
    }
    //25. Extract the productId of all the products
    @Test
    public void test005() {
List<Integer> productId = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product id is : " + productId );
        System.out.println("------------------End of Test---------------------------");
    }
    //26. Print the size of the data list
    @Test
    public void test006() {
        List<String> dataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The data list size  is : " + dataList.size() );
        System.out.println("------------------End of Test---------------------------");
    }
    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)
    @Test
    public void test007() {
        List<HashMap<String,Object>> valueOfProduct = response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of product is : " + valueOfProduct);
        System.out.println("------------------End of Test---------------------------");
    }
    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)
    @Test
    public void test008() {
        List<HashMap<?,Object>> model = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The model of product is : " + model );
        System.out.println("------------------End of Test---------------------------");
    }
    //29. Get all the categories of 8th products
    @Test
    public void test009() {
        List<String > categories = response.extract().path("data[7].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of 8th product is : " + categories );
        System.out.println("------------------End of Test---------------------------");
    }
    //30. Get categories of the store where product id = 150115
    @Test
    public void test010() {
        List<String> storeCategory = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The category of store is : " + storeCategory);
        System.out.println("------------------End of Test---------------------------");
    }
    //31. Get all the descriptions of all the products
    @Test
    public void test11() {
        List<String > description = response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The description of all products is : " + description );
        System.out.println("------------------End of Test---------------------------");
    }
    //32. Get id of all the all categories of all the products
    @Test
    public void test12() {
        List<String > categoryId = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The id of all categories of all products is : " + categoryId );
        System.out.println("------------------End of Test---------------------------");
    }
    //33. Find the product names Where type = HardGood
    @Test
    public void test13() {
        List<String> productType = response.extract().path("data.findAll{it.type == 'HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product name type is : " + productType );
        System.out.println("------------------End of Test---------------------------");
    }
    //34. Find the Total number of categories for the product where product name = Duracell - AA1.5V CopperTop Batteries (4-Pack)
    @Test
    public void test14() {
        List<String > numberOfCategories = response.extract().path("data[1].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The total no of Categories is : " + numberOfCategories );
        System.out.println("------------------End of Test---------------------------");
    }
    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void test15() {
        List<HashMap<String, ?>> createdAtPrice = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt price for all product is : " + createdAtPrice );
        System.out.println("------------------End of Test---------------------------");
    }
    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)”
    @Test
    public void test16() {
        List<String > nameOfAllCategories = response.extract().path("data[3].categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories is : " + nameOfAllCategories  );
        System.out.println("------------------End of Test---------------------------");
    }
    //37. Find the manufacturer of all the products
    @Test
    public void test17() {
        List<String > manufacturer = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The manufacturer of all the products is : " + manufacturer );
        System.out.println("------------------End of Test---------------------------");
    }
    //38. Find the imge of products whose manufacturer is = Energizer
    @Test
    public void test18() {
List<HashMap<?,Object>> image = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The image of products is : " + image );
        System.out.println("------------------End of Test---------------------------");
    }
    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void test19() {
        List<HashMap<?,Object>> createdAt = response.extract().path("data.findAll{it.price > 5.99}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The products price 5.99 createdAt is : " + createdAt );
        System.out.println("------------------End of Test---------------------------");
    }
    //40. Find the uri of all the products
    @Test
    public void test20() {
        List<String > urlOfAllProducts = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The urlOfAllProducts is : " + urlOfAllProducts );
        System.out.println("------------------End of Test---------------------------");
    }
}
