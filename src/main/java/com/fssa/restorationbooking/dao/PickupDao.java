package com.fssa.restorationbooking.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.fssa.restorationbooking.errors.DAOException;
import com.fssa.restorationbooking.model.PickupRequest;
import com.fssa.restorationbooking.util.ConnectionUtil;

public class PickupDao {

	
	public static boolean addPickupRequest(PickupRequest pickupRequest) throws SQLException {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        // SQL query to insert a new pickup request
	        String query = "INSERT INTO pickup_request(PickupName, PickupPhoneNumber, PickupAddress, PickupLandMark, PickupPincode, PickupDate, PickupTime, Email,BookId) " +
	                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

	        // Prepare and execute the SQL statement
	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            // Set parameter values for the SQL query
	            preparedStatement.setString(1, pickupRequest.getPickupName());
	            preparedStatement.setLong(2, pickupRequest.getPickupPhoneNumber());
	            preparedStatement.setString(3, pickupRequest.getPickupAddress());
	            preparedStatement.setString(4, pickupRequest.getPickupLandMark());
	            preparedStatement.setInt(5, pickupRequest.getPickupPincode());
	            preparedStatement.setDate(6, Date.valueOf(pickupRequest.getPickupDate()));
	            preparedStatement.setTime(7, Time.valueOf(pickupRequest.getPickupTime()));
	            preparedStatement.setString(8, pickupRequest.getEmail());
	            preparedStatement.setInt(9, pickupRequest.getBookId());

	            // Execute the SQL query to insert the pickup request
	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        throw ex;
	    }

	    // Return true to indicate a successful pickup request addition
	    return true;
	}

	
	public static List<PickupRequest> getSelectedPickupRequests(int PickupId) throws DAOException, SQLException {
	    List<PickupRequest> pickupRequests = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection
	                .prepareStatement("SELECT * FROM pickup_request WHERE PickupId = ?")) {
	            stmt.setInt(1, PickupId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {

	                    PickupRequest pRequest = new PickupRequest();
	                    pRequest.setPickupName(rs.getString("PickupName"));
	                    pRequest.setPickupPhoneNumber(rs.getLong("PickupPhoneNumber"));
	                    pRequest.setPickupAddress(rs.getString("PickupAddress"));
	                    pRequest.setPickupLandMark(rs.getString("PickupLandMark"));
	                    pRequest.setPickupPincode(rs.getInt("PickupPincode"));
	                    pRequest.setPickupDate(rs.getDate("PickupDate").toLocalDate());
	                    pRequest.setPickupTime(rs.getTime("PickupTime").toLocalTime());
	                    pRequest.setEmail(rs.getString("Email"));
	                    pRequest.setPickupId(rs.getInt("PickupId"));

	                    pickupRequests.add(pRequest);
	                }
	            }

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return pickupRequests;
	}

	
	public static List<PickupRequest> getPickupByBookId(int BookId) throws DAOException, SQLException {
	    List<PickupRequest> pickupRequests = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection
	                .prepareStatement("SELECT * FROM pickup_request WHERE BookId = ?")) {
	            stmt.setInt(1, BookId);
	            try (ResultSet rs = stmt.executeQuery()) {
	                if (rs.next()) {

	                    PickupRequest pRequest = new PickupRequest();
	                    pRequest.setPickupName(rs.getString("PickupName"));
	                    pRequest.setPickupPhoneNumber(rs.getLong("PickupPhoneNumber"));
	                    pRequest.setPickupAddress(rs.getString("PickupAddress"));
	                    pRequest.setPickupLandMark(rs.getString("PickupLandMark"));
	                    pRequest.setPickupPincode(rs.getInt("PickupPincode"));
	                    pRequest.setPickupDate(rs.getDate("PickupDate").toLocalDate());
	                    pRequest.setPickupTime(rs.getTime("PickupTime").toLocalTime());
	                    pRequest.setEmail(rs.getString("Email"));
	                    pRequest.setPickupId(rs.getInt("PickupId"));
	                    pRequest.setBookId(rs.getInt("BookId"));
	                    pickupRequests.add(pRequest);
	                }
	            }

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return pickupRequests;
	}

	
	
	
	
	public static boolean updatePickupRequest(PickupRequest pickup)throws SQLException, DAOException  {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        String sql = "UPDATE pickup_request SET PickupName = ?, PickupPhoneNumber = ?, PickupAddress = ?, PickupLandMark = ?, PickupPincode = ?, PickupDate = ?, PickupTime = ? WHERE BookId = ?";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, pickup.getPickupName());
	            preparedStatement.setLong(2, pickup.getPickupPhoneNumber());
	            preparedStatement.setString(3, pickup.getPickupAddress());
	            preparedStatement.setString(4, pickup.getPickupLandMark());
	            preparedStatement.setInt(5,pickup.getPickupPincode() );
	            preparedStatement.setDate(6, Date.valueOf(pickup.getPickupDate()));
	            preparedStatement.setTime(7, Time.valueOf(pickup.getPickupTime()));
	            preparedStatement.setInt(8, pickup.getBookId());
	            

	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return true;
	}


	public static List<PickupRequest> getPickupByEmail(String email) throws DAOException, SQLException {
	    List<PickupRequest> pickupRequests = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        try (PreparedStatement stmt = connection
	                .prepareStatement("SELECT * FROM pickup_request WHERE Email = ?")) {
	            stmt.setString(1, email);
	            try (ResultSet rs = stmt.executeQuery()) {
	                while (rs.next()) {
	                    PickupRequest pRequest = new PickupRequest();
	                    pRequest.setPickupName(rs.getString("PickupName"));
	                    pRequest.setPickupPhoneNumber(rs.getLong("PickupPhoneNumber"));
	                    pRequest.setPickupAddress(rs.getString("PickupAddress"));
	                    pRequest.setPickupLandMark(rs.getString("PickupLandMark"));
	                    pRequest.setPickupPincode(rs.getInt("PickupPincode"));
	                    pRequest.setPickupDate(rs.getDate("PickupDate").toLocalDate());
	                    pRequest.setPickupTime(rs.getTime("PickupTime").toLocalTime());
	                    pRequest.setEmail(rs.getString("Email"));
	                    pRequest.setPickupId(rs.getInt("PickupId"));
	                    pRequest.setBookId(rs.getInt("BookId"));
	                    

	                    pickupRequests.add(pRequest);
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	    return pickupRequests; 
	}



}
