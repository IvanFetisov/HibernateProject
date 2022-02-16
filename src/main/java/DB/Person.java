package DB;

import javax.persistence.Column;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "age", nullable = false)
    private int age;


    public Person (){

    }

    public Person(String username, int age){
        this.username = username ;
        this.age = age;

    }

    public int getId(){
        return id;
    }
    public void setId(){
        this.id= id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

}
