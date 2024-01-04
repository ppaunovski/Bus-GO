package mk.ukim.finki.busngo.model.exceptions;

public class InvalidPatnikIdException extends RuntimeException{
    public InvalidPatnikIdException() {
        super("The given patnik id does not exist!");
    }
}
