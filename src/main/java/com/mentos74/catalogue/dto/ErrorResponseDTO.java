package com.mentos74.catalogue.dto;

import com.mentos74.catalogue.enums.ErrorCode;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class ErrorResponseDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = -4153571219392893378L;

    private Date timeStamp;
    private String message;
    private ErrorCode errorCode;
    private List<String> details;
    private HttpStatus httpStatus;


    public ErrorResponseDTO(String message, ErrorCode errorCode, List<String> details, HttpStatus httpStatus) {
        super();
        this.timeStamp = new Date();
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
        this.httpStatus = httpStatus;
    }

    public static ErrorResponseDTO of(String message, List<String> details, final ErrorCode errorCode, HttpStatus httpStatus) {
        return new ErrorResponseDTO(message, errorCode, details, httpStatus);
    }


}
