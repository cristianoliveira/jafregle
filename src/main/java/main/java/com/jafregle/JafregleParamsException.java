package main.java.com.jafregle;

public class JafregleParamsException extends IllegalArgumentException {

    private static final long serialVersionUID = 1L;

    JafregleParamsException(){
        super("Incorret number of params");
    }

}
