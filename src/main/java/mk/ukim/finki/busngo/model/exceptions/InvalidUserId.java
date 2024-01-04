package mk.ukim.finki.busngo.model.exceptions;

public class InvalidUserId extends RuntimeException{
    public InvalidUserId() {
        super("The iven user id does not exist!");
    }
}
