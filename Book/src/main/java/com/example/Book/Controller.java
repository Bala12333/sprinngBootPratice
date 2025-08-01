package com.example.Book;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/")
    public String Welcome(){
        return  "Hello World";
    }
    @GetMapping("/name")
    public int GetAge(){
        return 1947;
    }
}
