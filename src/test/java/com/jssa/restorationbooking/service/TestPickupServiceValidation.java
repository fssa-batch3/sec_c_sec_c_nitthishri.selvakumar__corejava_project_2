package com.jssa.restorationbooking.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.restorationbooking.dao.PickupDao;
import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.model.PickupRequest;
import com.fssa.restorationbooking.service.PickupService;
import com.fssa.restorationbooking.validation.PickupValidation;

public class TestPickupServiceValidation {

    // Creates and returns a sample PickupRequest object for testing.
    public static PickupRequest getPickup() {
    	PickupRequest pickup = new PickupRequest("JohnDoe", 6380628123L, "123 Main St",
                "Landmark", 638053, LocalDate.of(2023, 9, 27), LocalTime.parse("14:00:00"),"kavi@gmail.com",1);

        return pickup;
    }
    public static PickupRequest getPickup1() {
    	PickupRequest pickup = new PickupRequest("Potter", 6380628123L, "123 Main St",
                "Landmark", 638053, LocalDate.of(2023, 9, 27), LocalTime.parse("14:00:00"),7);

        return pickup;
    }
    // Creates and returns another sample PickupRequest object for testing.


    // Creates and returns a PickupService object with associated dependencies for testing.
    public PickupService getPickupService() {
        PickupValidation pickupValidation = new PickupValidation();
        PickupDao pickupDao = new PickupDao();
        PickupService pickupService = new PickupService(pickupValidation, pickupDao);
        return pickupService;
    }

    @Test
    public void testAddPickup() throws DAOException, SQLException {
        PickupRequest pickup = getPickup();
        PickupService pickupService = getPickupService();
        Assertions.assertTrue(pickupService.addPickup(pickup));
    }

    @Test
    public void testUpdatePickup() throws DAOException, SQLException {
        PickupRequest pickup = getPickup1();
        PickupService pickupService = getPickupService();

        Assertions.assertTrue(pickupService.updatePickup(pickup));
    }

    @Test
    public void testGetParticularPickupDetails() throws DAOException, SQLException {
        PickupService pickupService = getPickupService();
        List<PickupRequest> pickupList = pickupService.getParticularPickup(3);
        for (PickupRequest ele : pickupList) {
            // Log or assert the pickup details as needed
            System.out.println(ele);
        }
    }
    
    @Test
    public void testGetPickUpByEmail() throws DAOException, SQLException {
    	  PickupService pickupService = getPickupService();
          List<PickupRequest> pickupList = pickupService.getPickUpByEmail("blackwoodalley@gmail.com");
          for (PickupRequest ele : pickupList) {
              // Log or assert the pickup details as needed
              System.out.println(ele);
          }
    }
    
    }
    
