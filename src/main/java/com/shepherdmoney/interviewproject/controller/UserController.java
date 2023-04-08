package com.shepherdmoney.interviewproject.controller;

import com.shepherdmoney.interviewproject.vo.request.CreateUserPayload;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @PutMapping("/user")
    public ResponseEntity<Integer> createUser(@RequestBody CreateUserPayload payload) {
        // TODO: Create an user entity with information given in the payload, store it in the database
        //       and return the id of the user in 200 OK response
        // Create a new user entity
        User user = new User();
        user.setName(payload.getName());
        user.setEmail(payload.getEmail());
        
        // Save the user to the database
        user = userRepository.save(user);
        
        // Return the ID of the created user in the response
        return ResponseEntity.ok(user.getId());
    }

    @DeleteMapping("/user")
    public ResponseEntity<String> deleteUser(@RequestParam int userId) {
        // TODO: Return 200 OK if a user with the given ID exists, and the deletion is successful
        //       Return 400 Bad Request if a user with the ID does not exist
        //       The response body could be anything you consider appropriate
            // Find the user with the given ID
        Optional<User> optionalUser = userRepository.findById(userId);
        
        // Return 400 Bad Request if the user does not exist
        if (optionalUser.isEmpty()) {
            return ResponseEntity.badRequest().body("User with ID " + userId + " does not exist");
        }
        
        // Delete the user from the database
        userRepository.deleteById(userId);
        
        // Return 200 OK response
        return ResponseEntity.ok("User with ID " + userId + " has been deleted");
    }
}
