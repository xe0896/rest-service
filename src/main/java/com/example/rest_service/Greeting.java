package com.example.rest_service; // Includes itself within this package

/*
    Declares a record which will then mean Java will automatically create
    functions such as toString(), hashCode() and equals() which is the meaning
    behind the lack of implementation in this code
*/
public record Greeting(long id, String content) {}