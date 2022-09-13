package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {
    private Registry registry = new Registry();

    @Test
    public void GivenPerson_WhenOlderthan100_ThenDEAD() {
        Person person = new Person("Majo", 15, 102, Gender.FEMALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);}

    @Test
    public void Givenperson_WhenAge9_ThenUNDERAGE() {
        Person person = new Person("Amy", 02, 9, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);}

    @Test
    public void Givenperson_WhenAge10_ThenUNDERAGE() {
        Person person = new Person("Mapis", 10, 3, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);}

    @Test
    public void Givenperson_WhenAgeminus2_ThenINVALID_AGE() {
        Person person = new Person("Grace", 03, -2,Gender.FEMALE, true );
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);}

    @Test
    public void Givenperson_WhenAge20_ThenVALID() {
        Person person = new Person("Abby", 03, 20,Gender.FEMALE, true );
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);}

    @Test
    public void Givenpeople_Whensameinformation_ThenDUPLICATED() {
        Person person = new Person("Ian", 04, 19,Gender.MALE, true );
        Person person1 = new Person("Ian", 04, 19,Gender.MALE, true );
        RegisterResult result = registry.registerVoter(person);
        RegisterResult result1 = registry.registerVoter(person1);

        Assert.assertEquals(RegisterResult.DUPLICATED, result1);}



}