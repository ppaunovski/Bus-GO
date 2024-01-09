package mk.ukim.finki.busngo.model.exceptions;

public class InvalidBiletIdException extends RuntimeException{
    public InvalidBiletIdException() {
        super("Invalid bilet id!");
    }
}
