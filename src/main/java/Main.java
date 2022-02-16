import DB.Person;
import DB.PersonService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
@SpringBootApplication
public class Main {
    //FIXME deleteByDiapozone необходимо разработать логику используя EntityManager для выборки возраста в диапозоне
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");

    public static void main(String[] args) {
        Person nikita = new Person("Никита", 28);
        PersonService.findByName("Никита" );
    }
}
