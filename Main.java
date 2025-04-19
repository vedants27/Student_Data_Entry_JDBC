//Main.java
// Name: Vedant Shitole
// PRN: 23070126143
// Batch: AIML B3

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); // To take user input
    StudentOperations operations = new StudentOperations(); // Instance of StudentOperations

        while (true) {
      // Display Menu
      System.out.println("\nMenu:");
      System.out.println("1. Add Student");
      System.out.println("2. Display Students");
      System.out.println("3. Search Student by PRN");
      System.out.println("4. Search Student by Name");
      System.out.println("5. Search Student by Position");
      System.out.println("6. Update Student Details");
      System.out.println("7. Delete Student");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      // Take integer input for user-choice
      int choice = Integer.parseInt(scan.nextLine());

      // Exit the program if choice is 0
      if (choice == 0) {
        System.out.println("Exiting the program...");
        break;
      }

      switch (choice) {

