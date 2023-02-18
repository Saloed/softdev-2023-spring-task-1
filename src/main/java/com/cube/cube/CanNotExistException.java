package com.cube.cube;

public class CanNotExistException extends Exception {

    private static final long serialVersionUID = 1L;

    public String toString() {
        return "Can not exist such size of cube";
    }
}
