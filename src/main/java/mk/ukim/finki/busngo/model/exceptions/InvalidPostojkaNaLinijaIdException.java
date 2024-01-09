package mk.ukim.finki.busngo.model.exceptions;

public class InvalidPostojkaNaLinijaIdException extends RuntimeException {
    public InvalidPostojkaNaLinijaIdException() {
        super("Invalid postoja na linija id!");
    }
}
