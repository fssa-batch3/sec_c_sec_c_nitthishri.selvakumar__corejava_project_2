package com.fssa.restorationbooking.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.errors.InvalidInputException;
import com.fssa.restorationbooking.model.User;

class UserValidatorTest {
    
    User getUser(){
        User user = new User();

        user.setUserName("Nitthishri");
        user.setEmailId("nitthishris.com");
        user.setPassword("Nitthi@2023");

        return user;
    }
    
//    Testcases for user validator

 
    @Test
    void testNullUser(){
        assertThrows(InvalidInputException.class, () -> UserValidator.validateUser(null));
    }
    
    
//    Testcases for email validator

    @Test
    void testValidEmail() {
        assertDoesNotThrow(() -> UserValidator.validateEmailId("aravind@gmail.com"));
    }
    
    @Test
    void testNullEmail() {
        assertThrows(InvalidInputException.class, () -> {
            UserValidator.validateEmailId(null);
        });
    }
    
    @Test
    void testEmptyEmailId(){
        assertThrows(InvalidInputException.class, ()-> UserValidator.validateEmailId(""));
    }

    @Test
    void testInvalidEmail() {
        assertThrows(InvalidInputException.class, () -> {
            UserValidator.validateEmailId("WrongEmail");
        });
    }
    
    //Testcases for user name validator



    @Test
    void testValidUserName() {
        assertDoesNotThrow(() -> UserValidator.validateUserName("     joe      "));
    }
    
//    @Test
//    void testNullUserName(){
//        assertThrows(InvalidInputException.class, ()-> UserValidator.validateUserName(null));
//    }
    
    @Test
    void testEmptyUserName(){
        assertThrows(InvalidInputException.class, ()-> UserValidator.validateUserName(""));
    }

    @Test
    void testInvalidUserNameWithNumber() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validateUserName("Nitthishri22"));
    }

    @Test
    void testInvalidUserNameLessThanThreeChar(){
        assertThrows(InvalidInputException.class, () -> UserValidator.validateUserName("ma"));
    }

    
    @Test
    void testInvalidUserNameSplChar(){
        assertThrows(InvalidInputException.class, () -> UserValidator.validateUserName("Nitthi@shri"));
    }

    
    //Testcases for userpassword
    @Test
    void testValidPassword() {
        assertDoesNotThrow(() -> UserValidator.validatePassword("P@ssw0rd"));
    }
    
//    @Test
//    void testNullPassword(){
//        assertThrows(InvalidInputException.class, ()-> UserValidator.validatePassword(null));
//    }
    
    @Test
    void testEmptyPassword(){
        assertThrows(InvalidInputException.class, ()-> UserValidator.validatePassword(""));
    }

    @Test
    void testInvalidPasswordLessThanEightChar() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validatePassword("Nitt@"));
    }


    @Test
    void testInvalidPasswordNoDigit() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validatePassword("IncorrectPassword@"));
    }

    @Test
    void testInvalidPasswordNoSplChar() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validatePassword("IncorrectPassword1"));
    }


    @Test
    void testInvalidPasswordNoLower() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validatePassword("INCORRECTPASS@1"));
    }

    @Test
    void testInvalidPasswordWhiteSpace() {
        assertThrows(InvalidInputException.class, () -> UserValidator.validatePassword("GappedPassword 404"));
    }



}