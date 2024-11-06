package org.example.userservicenew.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}
