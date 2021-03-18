package main.persons;

import java.util.Objects;

public abstract class Person {
    private static int uniqueId = 1;
    private int personId;
    private String name;


    public Person(String name){
        if(name.length()>0){
            this.name = name;
        }
        this.personId = uniqueId++;

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personId == person.personId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId);
    }
}
