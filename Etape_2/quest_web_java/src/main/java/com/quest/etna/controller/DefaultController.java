// Importing package in this code module
package com.quest.etna.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// Importing required classes
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Annotation
@Controller
// Main class
public class DefaultController {

    @RequestMapping("/testSuccess")
    @ResponseBody

    ResponseEntity<String> testSuccess() {
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    @RequestMapping("/testNotFound")
    @ResponseBody

    ResponseEntity<String> testNotFound() {
        return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/testError")
    @ResponseBody

    ResponseEntity<String> testError() {
        return new ResponseEntity<String>("error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}