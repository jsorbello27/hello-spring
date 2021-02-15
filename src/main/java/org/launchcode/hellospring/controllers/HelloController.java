package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//this creates the path hello on every method below


public class HelloController {

    //first method
    //this will signify the type of http request we will use(get put etc.)
    //handles requests at path/hello
//    @GetMapping("hello")
//    //response body is only used at first, later we will use templates
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    //this takes a query parameter, called name with the value LaunchCode
    //using the RequestParam is saying that we are expecting a request parameter called name
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        String properGreeting = HelloController.createMessage(name, language);
        return "<h3 style= 'color:purple;'>" + properGreeting + "</h3>";
    }

    //handles requests of the form /hello/LaunchCode
    //now LaunchCode is actually part of the path
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "hello " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){

        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +  //submit a request to /hello
                "<input type='text' name='name' />" +
                "<select name='language'>" +
                 "<option value='English'>English</option>" +
                 "<option value='Spanish'>Spanish</option>" +
                 "<option value='French'>French</option>" +
                 "<option value='Italian'>Italian</option>" +
                 "<option value='German'>German</option>" +
                "<input type='submit' value='Greet me!' />" +
                "</form>" +
                "</html>";
    }

    public static String createMessage(String name, String language){
        switch(language){
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour" + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
                return "Hallo" + name;
            case "English":
            default:
                return "Hello, " + name;
        }
    }

}