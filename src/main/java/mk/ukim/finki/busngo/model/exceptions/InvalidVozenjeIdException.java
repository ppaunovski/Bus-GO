package mk.ukim.finki.busngo.model.exceptions;

public class InvalidVozenjeIdException extends RuntimeException{
    public InvalidVozenjeIdException() {
        super("Inavlid vozenje id!");
    }
}
