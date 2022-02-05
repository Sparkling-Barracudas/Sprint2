
/**
 * Program to perform CRUD (Create, Read, Update, Destroy) operations on excel/csv files
 *
 * @authors Sparkling Barracudas
 */

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Crud {

    public static void main(String[] args) {

    }

    public void create() {

    }

    public void read() {

    }

    /**
     * uses franck search mothod to find the row and the updates the count of the item (for now)
     * @param prodId
     */
    public void update(String id) {
       
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String data[] = line.split(",");
            String returnLine;
            String current = data[0];
            if (current == id) {
               int quantity = data[1];
               double wholesale = data[2];
               double salePrice = data[3];
               String  supId = data[4];
               returnLine = current + quantity + wholesale + salePrice + supId;

               Scanner myObj = new Scanner(System.in);  // Create a Scanner object
               System.out.println("Enter New Amount");
       
               int newData = myObj.nextInt();  // Read user input
               data[1] = newData;// sets the newData to quantity collum
               break;
            }
        sc.close();
        return returneLine;

        
    }


    /**
     * replaces the entire row with a symbol that will notify the program to ignore that row
     * @param prodId
     */
    public void delete(String prodId) {

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String data[] = line.split(",");
            String returnLine;
            String current = data[0];
            if (current == id) {
               int quantity = data[1];
               double wholesale = data[2];
               double salePrice = data[3];
               String  supId = data[4];
               data[0] = "#";
               data[1] = "#";
               data[2] = "#";
               data[3] = "#";
               data[4] = "#";
               returnLine = current + quantity + wholesale + salePrice + supId;
               break;
            }
        sc.close();
        return returneLine;

    }
}