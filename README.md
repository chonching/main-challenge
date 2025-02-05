# main-challenge



## Getting started

## How To Build and Deploy via Terminal?
1. Open terminal and goto project directory
2. On the root project directory type "mvn clean package"
3. Generated Jar file will be inside target folder
4. Type "java -jar target/main-challenge-0.0.1-SNAPSHOT.jar"


## How To Build and Deploy via IntelijIDEA?
1. Open project and select Run(Green Play) button located on the upper right corner of the IDE

## How to test?
1. Run the project using one of the above method
2. Go to http://localhost:8080/api/directors?page=1&threshold=2

or

1. Open postman
2. Send POST request via http://localhost:8080/api/directors?page=1&threshold=2

## Sample Test Results:
**Test 1**
**Request URL:** http://localhost:8080/api/directors?page=2&threshold=2
**Response Body:** 
```
{
    "directors": [
        "Woody Allen",
        "Woody Allen",
        "Woody Allen",
        "Woody Allen"
    ]
}
```
**Test 2**
**Request URL:** http://localhost:8080/api/directors?page=1&threshold=2
**Response Body:** 
```
{
    "directors": [
        "Woody Allen",
        "Woody Allen",
        "Woody Allen"
    ]
}
```
**Test 3**
**Request URL:** http://localhost:8080/api/directors?page=1&threshold=3
**Response Body:** 
```
{
    "directors": []
}
```
**Test 4**
**Request URL:** http://localhost:8080/api/directors?page=1&threshold=1
**Response Body:** 
```
{
    "directors": [
        "M. Night Shyamalan",
        "M. Night Shyamalan",
        "Martin Scorsese",
        "Martin Scorsese",
        "Pedro Almodóvar",
        "Pedro Almodóvar",
        "Woody Allen",
        "Woody Allen",
        "Woody Allen"
    ]
}
```

## Additional note:
1. Added page parameter aside from threshold to make testing a lot easier
2. Added custom exception handling (@RestControllerAdvice) just to cater the scenerio of having exceptions, though the API might not produce BadRequest and NotFound exception
3. Added Junit test
