package mk.ukim.finki.busngo.model.exceptions;

public class InvalidLinijaIdException extends RuntimeException{
    public InvalidLinijaIdException() {
        super("Invalid linija id!");
    }
}
