package edu.eci.cvds.tdd.registry;

import java.util.ArrayList;

public class Registry {

    ArrayList<Person> personsArrayList = new ArrayList<Person>();
    public RegisterResult registerVoter(Person p) {
        // TODO Validate person and return real result.
        // DEAD > 100 , 0 < UNDERAGE < 18, INVALID AGE < 0, 0 < VALID < 200
        RegisterResult result = null;

        if (p.getAge() > 100 && !p.isAlive()){
            result = RegisterResult.DEAD;
        } else if (p.getAge() < 18 && p.getAge() > 0 && p.isAlive()) {
            result = RegisterResult.UNDERAGE;
        } else if (p.isAlive() && p.getAge() < 0) {
            result = RegisterResult.INVALID_AGE;
        }else if (p.isAlive() && p.getAge() > 0 && p.getAge() < 200) {
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
