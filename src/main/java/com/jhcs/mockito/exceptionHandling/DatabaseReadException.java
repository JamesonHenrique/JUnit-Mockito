package com.jhcs.mockito.exceptionHandling;

public class DatabaseReadException extends RuntimeException {
    public DatabaseReadException(

            String message
                                ) {
        super(message);
    }
}
