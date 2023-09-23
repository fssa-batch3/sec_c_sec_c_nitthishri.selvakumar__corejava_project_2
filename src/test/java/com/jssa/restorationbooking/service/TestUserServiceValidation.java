package com.jssa.restorationbooking.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.model.User;
import com.fssa.restorationbooking.service.UserService;
import com.google.protobuf.ServiceException;

class TestUserServiceValidation {

    UserService userService = new UserService();

    private User getUser() {
        User user = new User();
        user.setUserName("TestName");
        long nanoTime = System.nanoTime();
        user.setEmailId("test" + nanoTime + "@test.com");
        user.setPassword("TestP@$$W0rd");

        return user;
    }

    @Test 
    void testValidUserSignUp() {
        User user = getUser();
        assertDoesNotThrow(() -> userService.userSignUp(user));
    }

    @Test
    void testUserSignUpInvalidUserName() {
        User user = getUser();
        user.setUserName("Nitthishri22");
        assertThrows(ServiceException.class, () -> userService.userSignUp(user));
    }

    @Test
    void testValidUserLogin() throws ServiceException {
    	
    	Assertions.assertTrue(userService.userLogin("blackwoodalley@gmail.com","Nitthi@0104"));
//    	assertDoesNotThrow(() -> userService.userLogin("testuser01@gmail.com", "P@$$w0rd"));
    }
 
    @Test
    void testUserLoginInvalidInput() {
        assertThrows(ServiceException.class, () -> userService.userLogin("", "weakPassword"));
    }


    @Test
    void testDeleteUserValidInput() {
       
        assertDoesNotThrow(() -> userService.deleteUser("jallel@gmail.com"));
    }

    @Test
    void testDeleteUserInvalidInput() {
        
        assertThrows(ServiceException.class, () -> userService.deleteUser("notmyemail@gmail.com"));
    }



}