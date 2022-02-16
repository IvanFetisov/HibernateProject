package DB;

import org.hibernate.mapping.List;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Transactional// Внутри этого класса происходят транзакции
/*
Этот класс является посредником среди классов service и main.
 */
public class PersonDAO {
    private static final EntityManagerFactory MANAGER_FACTORY = Persistence.createEntityManagerFactory("hibernate");
    Person person = new Person();
    @PersistenceContext
    private EntityManager entityManager;
    private EntityTransaction entityTransaction;

    public int add(Person person) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(person);
        entityTransaction.commit();

        return person.getId();

    }

    public void edit (int id, Person person) {
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person newPerson = entityManager.find(Person.class,id);
        newPerson.setAge(person.getAge());
        newPerson.setUsername(person.getUsername());
        entityManager.persist(newPerson);
        entityTransaction.commit();
    }
    public void delete (int id){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person1 = entityManager.find(Person.class,id);
        entityManager.remove(person1);
        entityTransaction.commit();
    }
    /*  public void deleteByDiapozone (int age){

        EntityManager entityManager = MANAGER_FACTORY.createEntityManager();

        String query = "SELECT i FROM Item i WHERE i.age >:age1 ";

        TypedQuery<DB.Person> typedQuery = entityManager.createQuery(query, DB.Person.class);
        typedQuery.setParameter("age1", age);
        DB.Person person = typedQuery.getSingleResult();
    }
     */

    public void deleteByName (String username){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class,username);
        entityManager.remove(person);
        entityTransaction.commit();
    }
    public void findByName(String username){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Person person = entityManager.find(Person.class, username);
        System.out.println(person);
    }
    public void findPersonBySpaceId(int minimumId, int maximumId){
        entityManager = MANAGER_FACTORY.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        String query = "SELECT i FROM persons i WHERE i.id < :i.minimumId AND i.id >: i.maximumId";
    TypedQuery<Person> personList = entityManager.createQuery(query, Person.class);

    }


}