package Errors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestError implements AppError{

    String timestamp ;
    private int status;
    private String error;
    String path;
}
