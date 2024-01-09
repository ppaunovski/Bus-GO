package mk.ukim.finki.busngo.model.exceptions;

public class UserShouldNotBeTicketedException extends RuntimeException{
    public UserShouldNotBeTicketedException(String message) {
        super(message);
    }
}
