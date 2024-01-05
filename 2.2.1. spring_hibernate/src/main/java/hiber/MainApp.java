package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      //создаю пользователей
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      User user4 = new User("User4", "Lastname4", "user4@mail.ru");

      //создаю машины
      Car car1 = new Car("Model1", 1);
      Car car2 = new Car("Model2", 2);
      Car car3 = new Car("Model3", 3);
      Car car4 = new Car("Model4", 4);

      // присваиваю пользователю машину и добавляю этого пользователя в базу
      user1.setUserCar(car1);
      userService.add(user1);
      user2.setUserCar(car2);
      userService.add(user2);
      user3.setUserCar(car3);
      userService.add(user3);
      user4.setUserCar(car4);
      userService.add(user4);

      System.out.println("-------------------");

      // вывожу в консоль пользователя по его машине
      System.out.println(userService.getUsers("Model2", 2));
      System.out.println(userService.getUsers("Model4", 4));
      System.out.println(userService.getUsers("Model1", 1));
      System.out.println(userService.getUsers("Model3", 3));

      context.close();
   }
}
