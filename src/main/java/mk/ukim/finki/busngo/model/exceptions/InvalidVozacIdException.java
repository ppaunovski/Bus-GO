package mk.ukim.finki.busngo.model.exceptions;

public class InvalidVozacIdException extends RuntimeException{
    public InvalidVozacIdException() {
        super("Invalid vozac id!");
    }
}
