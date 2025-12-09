package com.avsoft.hostelmanagement.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data // Generates Getters, Setters, toString, etc. (Requires Lombok)
@NoArgsConstructor
public class ApiResponse<T> {

    private String message;
    private T data;
    private boolean success;
    private LocalDateTime timestamp;

    // Constructor used in your controller: new ApiResponse<>(message, data)
    public ApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
        this.success = true; // Default to true for successful responses
        this.timestamp = LocalDateTime.now();
    }

    // Optional: Constructor for error scenarios (if you use it in ExceptionHandler)
    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.data = null;
        this.success = success;
        this.timestamp = LocalDateTime.now();
    }
}