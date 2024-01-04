package mk.ukim.finki.busngo.model.exceptions;

public class InvalidCredentialsException extends RuntimeException{
    public InvalidCredentialsException() {
        super("The credentials entered are invalid!");
    }
}
