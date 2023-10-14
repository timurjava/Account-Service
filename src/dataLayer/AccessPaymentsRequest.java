package dataLayer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessPaymentsRequest {

    String name;
    String lastname;
    String email;
    String password;
}
