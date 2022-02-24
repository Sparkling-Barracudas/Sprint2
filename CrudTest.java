import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.util.*;
import org.junit.jupiter.api.Test;

class CrudTest {
	/**
	 * A Test Method that tests that the 
	 * Create method is adding the id to the database
	 */
	@Test
	void testCreateMethod() {

		
		Crud crud = Crud.getInstance();
		Connection c = crud.connect();
		crud.create(c);

		 try {
			 
			 	String productId = "732";
	            Statement stmt = null;
	            c.setAutoCommit(false);
	            stmt = c.createStatement();

	            ResultSet rs = stmt.executeQuery("Select * FROM Products WHERE product_id = '" + productId + "';");

	            while (rs.next()) {
	                String idRet = rs.getString("product_id");
	                //int quantRet = rs.getInt("quantity");
	                //float costRet = rs.getFloat("wholesale_cost");
	                //float saleRet = rs.getFloat("sale_price");
	                //String supRet = rs.getString("supplier_id");
	                String expected = "732";
	                assertEquals(expected, idRet);

	            }
	            crud.delete(c, "732");
	            rs.close();
	            stmt.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
		
		
		

	}
	/**
	 * Method that tests the read method
	 * The method ensures that the read method is gathering the correct data
	 */
	@Test
	void testReadMethod() {
		Crud crud = Crud.getInstance();
		Connection c = crud.connect();
		crud.read(c, "5TXAQVSQ1SPS");
		try {
			Statement stmt = null;
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String productId = "5TXAQVSQ1SPS";
			ResultSet rs = stmt.executeQuery("Select * FROM Products WHERE product_id = '" + productId + "';");
			while(rs.next()) {
				String expected = "5TXAQVSQ1SPS";
				String idRet = rs.getString("product_id");
				assertEquals(expected, idRet);
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Test
	void testUpdateMethod() {
		Crud crud = Crud.getInstance();
		Connection c = crud.connect();
		crud.update(c, "5TXAQVSQ1SPS");
		try {
			Statement stmt = null;
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String productId = "5TXAQVSQ1SPS";
			ResultSet rs = stmt.executeQuery("Select * FROM Products WHERE product_id = '" + productId + "';");
			while(rs.next()) {
				

				 int quantRet = rs.getInt("quantity");
                float costRet = rs.getFloat("wholesale_cost");
                float saleRet = rs.getFloat("sale_price");
                String supRet = rs.getString("supplier_id");
				assertEquals(100, quantRet);
				assertEquals(12.5, costRet);
				assertEquals(23.5, saleRet);
				assertEquals("LFWDAWDA", supRet);
			}
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	@Test
	void testDeleteMethod() {
		Crud crud = Crud.getInstance();
		Connection c = crud.connect();
		crud.create(c);
		try {
			Statement stmt = null;
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String productId = "737";
			ResultSet rs = stmt.executeQuery("Select * FROM Products WHERE product_id = '" + productId + "';");
			while(rs.next()) {
				

				String idRet = rs.getString("product_id");
				String expected = "737";
				assertEquals(expected, idRet);
			}
			
			
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		crud.delete(c, "737");
		try {
			Statement stmt = null;
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String productId = "737";
			ResultSet rs = stmt.executeQuery("Select * FROM Products WHERE product_id = '" + productId + "';");
			
			if(rs.next() == false) {
				
				assertFalse(rs.next());
				assertEquals(false, rs.next());
			
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}
}