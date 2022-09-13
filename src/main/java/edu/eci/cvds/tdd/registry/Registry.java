package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    ArrayList<Person> personsArrayList = new ArrayList<Person>();
    public RegisterResult registerVoter(Person p) {

        // DEAD isn't alive and age > 100
        //UNDERAGE age < 18, age > 0 and alive
        //INVALID_AGE age < 0 and alive
        //VALID age < 100, age > 17 and alive
        //DUPLICATED if id duplicate
        RegisterResult result = null;

        if (p.getAge() > 100 && !p.isAlive()){
            result = RegisterResult.DEAD;
        } else if (p.getAge() < 18 && p.getAge() > 0 && p.isAlive()) {
            result = RegisterResult.UNDERAGE;
        } else if (p.isAlive() && p.getAge() < 0) {
            result = RegisterResult.INVALID_AGE;
        }else if (p.isAlive() && p.getAge() < 100 && p.getAge() > 17) {
            result = RegisterResult.VALID;
        }for (Person registerPerson : personsArrayList){
            if (p.getId() == registerPerson.getId()){
                return RegisterResult.DUPLICATED;
            }
        }

        this.personsArrayList.add(p);
        return result;
    }
}
