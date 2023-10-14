package account.controllerLayer;


import Errors.BadRequestError;
import dataLayer.ChangePassRequest;
import dataLayer.ChangePassResponse;
import dataLayer.SignUpRequest;
import dataLayer.SignUpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final String BAD_REQUEST = "Bad Request";
    private final String SIGNUP_PATH = "/api/auth/signup";

    @PostMapping("/auth/signup/")
    public ResponseEntity<?> postSignUp(@RequestBody SignUpRequest request) {
        Optional<String> password = Optional.ofNullable(request.getPassword());
        Optional<String> name = Optional.ofNullable(request.getName());
        Optional<String> email = Optional.ofNullable(request.getEmail());
        Optional<String> lastName = Optional.ofNullable(request.getLastname());
        if (password.isPresent() && !password.get().equals("") && name.isPresent() && !name.get().equals("") && email.isPresent() && lastName.isPresent() && !lastName.get().equals("")) {
            if( request.getEmail().contains("@acme.com")) {
                return new ResponseEntity<>(new SignUpResponse(request.getName(), request.getLastname(), request.getEmail()), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(new BadRequestError("<date>",HttpStatus.BAD_REQUEST.value(), BAD_REQUEST,SIGNUP_PATH),HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/auth/changepass")
    public ResponseEntity<?> postChangePass(@RequestBody ChangePassRequest request) {
        return new ResponseEntity<>(new ChangePassResponse(request.getName(), request.getLastname(), request.getEmail()),HttpStatus.OK);
    }
    @GetMapping("/Test")
    public String Test(){
        return "Hello";
    }


}
