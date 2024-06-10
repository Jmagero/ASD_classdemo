package miu.edu.cs.asd.userdata.exceptional.user;

public class UserNotFoundExceptional extends RuntimeException{
    public UserNotFoundExceptional(String message) {
        super(message);
    }

}
