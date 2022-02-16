package DB;


public class PersonService {
    private static final PersonDAO PersonDAO = new PersonDAO();
   /*
   Этот класс передает методы из DB.PersonDAO в Main класс
    */
    public static int add (Person person){
        return PersonDAO.add(person);
    }
    public static void edit (int id, Person person){
         PersonDAO.edit(id, person);
    }
    public static void delete (int id) {
        PersonDAO.delete(id);
    }
    public static void deleteByName(String username){
        PersonDAO.deleteByName(username);
    }
    public static void findByName (String username){
        PersonDAO.findByName(username);
    }
    public static void findPersonBySpaceId (int minimumId, int maximumId){
        PersonDAO.findPersonBySpaceId(minimumId,maximumId);
    }
}
