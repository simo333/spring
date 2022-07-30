package pl.coderslab.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.coderslab.beans.EmailService;
import pl.coderslab.beans.HelloWorld;
import pl.coderslab.beans.MessageSender;

public class SpringDiApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
        helloWorld.printMessage();
        EmailService emailSender = context.getBean("emailSender", EmailService.class);
        emailSender.send();
        MessageSender messageSender = context.getBean("messageSender", MessageSender.class);
        messageSender.sendMessage();
        MessageSender messageSender2 = context.getBean("messageSender2", MessageSender.class);
        messageSender2.sendMessageFromProperty();
        context.close();
    }
}
