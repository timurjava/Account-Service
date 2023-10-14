package account.controllerLayer;

import dataLayer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ServiceController {

    @PutMapping("/admin/user/role")
    public ResponseEntity<?> getPayment(@RequestBody AccessPaymentsRequest request) {
        return new ResponseEntity<>(new AccessPaymentsResponse(request.getName(), request.getLastname(), request.getEmail()), HttpStatus.OK);
    }

    @DeleteMapping ("/admin/user")
    public ResponseEntity<?> postPayment(@RequestBody UploadPaymentsRequest request) {
        return new ResponseEntity<>(new UploadPaymentResponse(request.getName(), request.getLastname(), request.getEmail()),HttpStatus.OK);
    }
    @GetMapping("/admin/user")
    public ResponseEntity<?> Test(@RequestBody UpdatePaymentsRequest request){
        return new ResponseEntity<>(new UpdatePaymentsResponse(request.getName(), request.getLastname(), request.getEmail()),HttpStatus.OK);
    }

}
