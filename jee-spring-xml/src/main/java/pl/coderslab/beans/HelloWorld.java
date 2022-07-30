package pl.coderslab.beans;

public class HelloWorld {
    private String message;

    public HelloWorld(String message) {
        this.message = message;
    }

    public HelloWorld() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println("Your Message : " + message);
    }

}
