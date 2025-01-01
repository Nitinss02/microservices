package com.microservices.rating.Exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }

    public ResourceNotFound() {
        super("Rating is not Found");
    }

}
