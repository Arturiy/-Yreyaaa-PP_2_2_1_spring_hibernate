package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.clearTable();

        Car car = new Car("BMW", 1);
        Car car2 = new Car("Lada", 3);

        User user = new User("Yra", "Ivanov", "Yra@bk.com");
        user.setCar(car);
        userService.add(user);

        User user1 = new User("Misha", "Petrov", "Misha@bk.com");
        user1.setCar(car2);
        userService.add(user1);

        User user2 = new User("Dima", "Sidorov", "Dima@bk.com");
        userService.add(user2);

        List<User> resultUsers = userService.listUsers();
        for (User currentUser : resultUsers) {
            System.out.println("Id = " + currentUser.getId());
            System.out.println("First Name = " + currentUser.getFirstName());
            System.out.println("Last Name = " + currentUser.getLastName());
            System.out.println("Email = " + currentUser.getEmail());
            System.out.println("Car = " + (currentUser.getCar().isPresent() ? currentUser.getCar().get() : null));
            System.out.println();
        }

        System.out.println(userService.getUserByCar("BMW", 1));

        context.close();
    }
}
