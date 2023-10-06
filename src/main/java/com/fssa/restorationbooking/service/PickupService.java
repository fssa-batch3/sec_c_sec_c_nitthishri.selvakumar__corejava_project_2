package com.fssa.restorationbooking.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.restorationbooking.dao.PickupDao;
import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.errors.InvalidPickUpDetailException;
import com.fssa.restorationbooking.model.PickupRequest;
import com.fssa.restorationbooking.validation.BookingValidation;
import com.fssa.restorationbooking.validation.PickupValidation;

public class PickupService {
     


	    private PickupDao pickupDao;
	    private PickupValidation pickupValidation;

	    public PickupService(PickupValidation pickupValidation, PickupDao pickupDao) {
	        this.pickupDao = new PickupDao(); // Initialize the DAO instance
	    }
	
	    public PickupService() {
			this.pickupDao = new PickupDao();
		}
 

		public boolean addPickup(PickupRequest pickup) throws DAOException, SQLException {
	        try {
				if (pickupValidation.validatePickUpDetails(pickup)) {
				    return pickupDao.addPickupRequest(pickup);
				    
				}
			} catch (InvalidPickUpDetailException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
	        return true;
	        
	    }

	    public boolean updatePickup(PickupRequest pickup) throws DAOException, SQLException {
	        try {
				try {
					if (pickupValidation.validatePickUpDetails1(pickup)) {
					    try {
					        return pickupDao.updatePickupRequest(pickup);
					    } catch (SQLException e) {
					        e.printStackTrace();
					    }
					}
				} catch (InvalidPickUpDetailException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return true;
	    }
	
	 
	    public List<PickupRequest> getParticularPickup(int PickupId) throws DAOException, SQLException {

	        return pickupDao.getSelectedPickupRequests(PickupId);
	    } 

	    public List<PickupRequest> getPickUpByEmail(String pickUpEmail) throws DAOException, SQLException {
	    
			
				return pickupDao.getPickupByEmail(pickUpEmail);
		
	    }
	    
	    public List<PickupRequest> getPickUpByBookId(int BookId) throws DAOException, SQLException {
		    
	        return pickupDao.getPickupByBookId(BookId);
	    }
	      
}
