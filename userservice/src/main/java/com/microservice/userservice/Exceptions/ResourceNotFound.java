package com.microservice.userservice.Exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound() {
        super("Resource not found On Server");
    }

}
