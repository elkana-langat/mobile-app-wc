package com.langat.mobileappws;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

@RestController
@RequestMapping("users") // http://localhost:8080/users 
public class UserController {

    @GetMapping
    public String getUsers(@RequestParam(value="page", defaultValue="1") int page, 
                            @RequestParam(value="limit", defaultValue="1") int limit) {
        return "get users was called with page = " + page + " and limit = " + limit;
    }
    
    @GetMapping(path="/{userId}", produces = { "application/xml", "application/json" })
    public ResponseEntity<UserRest> getUser(@PathVariable String userId) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName("Elkana");
        returnValue.setLastName("Langat");
        returnValue.setEmail("elkanahlangatt@gmail.com");

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PostMapping(consumes = { "application/xml", "application/json" }, produces = { "application/xml", "application/json" })
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestMode userDetails) {
        UserRest returnValue = new UserRest();
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());
        returnValue.setEmail(userDetails.getEmail());
        
        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
