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

	            rs.close();
	            stmt.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	            System.exit(1);
	        }
		
		
		

	}
}
