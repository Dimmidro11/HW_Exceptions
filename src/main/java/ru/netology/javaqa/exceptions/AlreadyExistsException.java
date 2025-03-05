package ru.netology.javaqa.exceptions;

public class AlreadyExistsException extends  RuntimeException{

    public AlreadyExistsException(String s) {
        super(s);
    }
}
