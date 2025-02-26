/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loanmanage;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.HashMap;
import static loanmanage.LoanManagementSystem.DatabaseConnection.getConnection;




class Loan {
    private String name;
    private int id;
    private int amount;//holdername

    public Loan(String name, int id, int amount) {
        this.name = name;
        this.id = id;
        this.amount= amount;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int  getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount= amount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "name='" + name + '\'' +
                ", id='" + id+ '\'' +
                ", amount='" + amount +
                '}';
    }
}

class Customer {
    Scanner scanner = new Scanner(System.in);
    private  Connection connection;
    private HashMap<String, String> users;


    private int id; // Assuming auto-incrementing primary key in the database
    private String username;
    private String password;
    private String name;
    //private double income;
    private String role; // Can be "manager" or "customer"

    public Customer() {
        this.connection = getConnection();
        this.users = new HashMap<>();
    }

    public Customer(int id, String username, String password, String name, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        //this.income = income;
        this.role = role;
    }

    public int SearchLoan() {
        
      List<String> loanTypes = Arrays.asList("Personal", "Home","Medical", "Education");
      System.out.println("Available Loan Types");
      int i,j=-1;
      for (i = 0; i < loanTypes.size(); i++) {
      System.out.println((i + 1) + ". " + loanTypes.get(i));
      }
      int selection = scanner.nextInt();
      if (selection > 0 && selection <= loanTypes.size()) {
        j=selection;
      } else {
       System.out.println("Invalid selection. Please try again.");
       SearchLoan();
      }
      uploadDocument(j);
      return j;
    }
    
    public void uploadDocument(int loanId) {
     //int k=-1;
     //int m[20];
     //System.out.println("Enter the number documents that you are going to upload:");
    // k=scanner.nextInt();
     //System.out.println("Enter the document name:");
    // String documentName = scanner.next();
    // System.out.println("Enter the document type:");
     //System.out.println("Document Types");
     List<String> docTypes=Arrays.asList();
     //List<String> docTypes = Arrays.asList("Medical Certificate", "Bonafide","Income","Smart ID card for personel details");
     System.out.println("loanid :"+loanId);
     switch(loanId){
         case 0:
             docTypes = Arrays.asList("Smart ID card for personel details","Income Certificate");
         case 1:
             docTypes = Arrays.asList("Smart ID card for Personel Details","Land Documents","Income Certificate");
         case 2:
             docTypes = Arrays.asList("Medical Report","Smart ID card for personel details");
         case 3:
             docTypes = Arrays.asList("Bonafide Certificate","Smart ID card for personel details");
         default:
             System.out.println("Invalid Options");
             break;
     }
     System.out.println("Documents Needed:");
     int i;
     for (i = 0; i < docTypes.size(); i++) {
      System.out.println((i + 1) + ". " + docTypes.get(i));
      }
     checkEligibility(loanId);
    //System.out.println("Enter the choices");*/
    /*  int i,j;
      List<Integer> m =Arrays.asList();
      for (i = 0; i < k; i++) {
        System.out.println("Enter the choices");
        int docId = scanner.nextInt();
        m.add(docId);
      }
      int selection = scanner.nextInt();
      if (m.size() > 0 && m.size()<= docTypes.size()) {
        j=m.size();
        Manager man=new Manager();
        man.checkEligibility(loanId,j,m);
      } else {
       System.out.println("Invalid selection. Please try again.");
       uploadDocument(loanId);*/
      }
    
    public void checkEligibility(int loanId) {
      int h=-1,id,age;
      String username="";
      String name="";
      double income;
      switch(loanId){
          case 0:
              System.out.println("Enter ID");
              id=scanner.nextInt();
              System.out.println("Enter username: ");
              username = scanner.next();
              System.out.println("Enter name: ");
              name = scanner.next();
              System.out.println("Enter age");
              age=scanner.nextInt();
              System.out.println("Enter income: ");
              income = scanner.nextDouble();
              if(id==loanId && id < 1 && username==name && income>20000){
                  h=1;
              }
              break;
          case 1:
              System.out.println("Enter ID");
              id=scanner.nextInt();
              System.out.println("Enter username: ");
              username = scanner.next();
              System.out.println("Enter name: ");
              name = scanner.next();
              System.out.println("Enter age");
              age=scanner.nextInt();
              System.out.println("Enter income: ");
              income = scanner.nextDouble();
              System.out.println("Land Details");
              System.out.println("Enter City name:");
              String city=scanner.next();
              System.out.println("Enter area of the land in acres: ");
              float land = scanner.nextFloat();
              if(id==loanId && id < 1 && username==name && income>20000 && land>3.5){
                  h=1;
              }
              break;
          case 2:
              System.out.println("Enter ID");
              id=scanner.nextInt();
              System.out.println("Enter username: ");
              username = scanner.next();
              System.out.println("Medical Report Details");
              System.out.println("Enter Patient Name: ");
              name = scanner.next();
              System.out.println("Enter Disease name: ");
              String disease = scanner.next();
              System.out.println("Enter age");
              age=scanner.nextInt();
              System.out.println("Enter guardian income: ");
              income = scanner.nextDouble();
              if(id==loanId && id < 1 && username==name && income>20000){
                  System.out.println("Your documents are sufficient for this loan");
                 // h=1;
              }
              else
                  System.out.println("Your documents are not  sufficient for this loan");
                  
              break;
          case 3:
              System.out.println("Enter ID");
              id=scanner.nextInt();
              System.out.println("Enter username: ");
              username = scanner.next();
              System.out.println("Bonafide Certificate Details");
              System.out.println("Enter Student name: ");
              name = scanner.next();
              System.out.println("Enter School or college: ");
              String sccl = scanner.next();
              System.out.println("Enter age");
              age=scanner.nextInt();
              if(sccl=="School" || sccl=="school"){
              //    case "School":
                      System.out.println("Enter School Name: ");
                      String school = scanner.next();
                      System.out.println("Enter Class: ");
                      int sclass = scanner.nextInt();
                      h=1;
              }
              else if(sccl=="College" || sccl=="college"){
                //  case "College" || "":
                      System.out.println("Enter College Name");
                      System.out.println("Submit 10th marksheet");
                      System.out.println("Enter 10th marks");
                  //default:
                     // System.out.println("Invalid Otion");
                     h=1;
              }
              else{
                  System.out.println("Invalid Otion");
                  
              }
              break;
          default:
              System.out.println("Invalid Choice");
              //else {
                  //System.out.println("Your request for loan is rejected");
      }
     /* approveLoan(h);
      if(h==1){
          Approval a=new Approval();
          a.generateLoanReport(username,name,loanId);
      }
      else{
          System.out.println("Your documents are not sufficient for this loan");
      }
      
  }
 ( public void approveLoan(int h) {
      if(h==1){
          Approval a=new Approval();
      }
      else{
          System.out.println("Your documents are not sufficient for this loan");
      }
  }*/
  
 // public void trackingLoanDetails() {}
  }
    
    public void registerCustomer() {
        
        System.out.println("Enter ID");
        int id=scanner.nextInt();
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();
      
        String role="customer";
        if (!users.containsKey(username)) {
            String sql="INSERT INTO customers(id,username,password,name,role)Values(?,?,?,?,?)";
            try(PreparedStatement stmt = connection.prepareStatement(sql)) {
               stmt.setInt(1, id);
                stmt.setString(2, username); 
                stmt.setString(3, password);
                stmt.setString(4, name); 
                stmt.setString(5, role);
                
                 stmt.executeUpdate();
                  System.out.println("Registration successful for user: " + username);
                  LoanManage loan = new LoanManage();
                  loan.login();
            }catch (SQLException e) {
                System.out.println("User " + username + " already exists.");
            }
        
    }    
       // Customer newCustomer = new Customer(id,username, password, name, role);
        //customers.add(newCustomer);
}
}
class Approval {
    public Integer loanId;

  public Integer managerId;

  public Integer cusId;
  public Approval() {
        
        this.connection = getConnection();
        
    }
  public void approvedLoanDetails() {
  }
private  Connection connection;
  public void generateLoanReport() {
     String sql = "SELECT * FROM loan";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            System.out.println("List of Loans:");
            while (rs.next()) {
                String name = rs.getString("loan_name");
                int id = rs.getInt("loan_id");
                int amonut = rs.getInt("amount");
                //System.out.println("Name: " + name + ", "Location: " + location + ", Capacity: " + capacity);
                System.out.println("Loan: " + name + ", id: " + id + ", amount: " + amonut);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving loans: " + e.getMessage());
        }
 
  }
}
    
class Manager {
    private ArrayList<Loan> loans;
    //private Connection connection;
    
     private static Connection connection;
    private HashMap<String, String> users;

    public Manager() {
        this.loans = new ArrayList<>();
        this.connection = getConnection();
        this.users = new HashMap<>();
    }
    
    public void addLoan(String loan_name,int loan_id,int amount) {
        if (!check_loaneligibility(loan_name, amount)) {
            String sql = "INSERT INTO loan (loan_name, loan_id,amount) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, loan_name);
                //stmt.setInt(2, loanId);
                 stmt.setInt(2,loan_id);
                  stmt.setInt(3,amount);
                stmt.executeUpdate();
                System.out.println("Loan " + loan_name + " booked successfully for " + amount);
            } catch (SQLException e) {
                System.out.println("Error booking loan: " + e.getMessage());
            }
        } else {
            System.out.println("Loan " + loan_name + " is already booked for " + amount);
        }
    }

    private boolean check_loaneligibility(String loan_name, int amount) {
        String sql = "SELECT * FROM loan WHERE loan_name = ? AND amount = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, loan_name);
            stmt.setInt(2, amount);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // If there is a result, venue is already booked
        } catch (SQLException e) {
            System.out.println("Error checking loan  eligibility: " + e.getMessage());
        }
        return true; // Return true to prevent booking in case of error
    }
    
    public void show_loanDetails()
    {
        System.out.println("------------------------------------------");
        System.out.println("*****Loanname:Medical Loan*****");
        System.out.println("loanid:14");
        System.out.println("400000");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("******loanname:Home Loan*****");
        System.out.println("loanid:73");
        System.out.println("--------------------------------------------");
        
    }
    
    public void displayVenues() {
        String sql = "SELECT * FROM loan";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            System.out.println("List of Loans:");
            while (rs.next()) {
                String name = rs.getString("loan_name");
                int amonut = rs.getInt("amount");
                int id = rs.getInt("loan_id");
                //System.out.println("Name: " + name + ", "Location: " + location + ", Capacity: " + capacity);
                System.out.println("Loan: " + name + ", id: " + id + ", amount: " + amonut);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving loans: " + e.getMessage());
        }
    }

}

public class LoanManage {
    public static void main(String[] args) {
        LoanManage loan = new LoanManage();
        int choice;
        do{
            System.out.println("\n====Loan Management System====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loan.login();
                    break;
                case 2:
                    Customer c = new Customer();
                    c.registerCustomer();
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        }while(choice!=3);
    }
    
    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/loan", "root", "");
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
        return conn;
    }
    
    private static Connection connection;
    
    public boolean login() {
        LoanManage loan = new LoanManage();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        Connection connection = getConnection();
        String sql = "SELECT * FROM registration WHERE username = ? AND password = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
               // System.out.println("Login successful!");
                if (username!="manager") {
                    System.out.println("Login successful!");
                   // loan.adminMenu();
                   loan.customerMenu(username);
                } else {
                    //System.out.println("Login successful!");
                    //loan.customerMenu(username);
                    loan.adminMenu();
                }
            }
            else {
                System.out.println("Invalid username or password!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Login failed!");
        }
            return false;
    }
     
    public void adminMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Add Customer");
            System.out.println("2. Approve loan application");
            System.out.println("3. View Loan Details");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Customer c = new Customer();
                    c.registerCustomer();
                    break;
                case 2:
                    Manager a=new Manager();
                    //a.approveLoan(0);
                    break;
                case 3:
                    Manager m = new Manager();
                    m.show_loanDetails();
                case 4:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }

    public void customerMenu(String username) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nCustomer Menu");
            System.out.println("1. Apply for loan");
            System.out.println("2. View loan application status");
            System.out.println("3. Logout");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            int loanId=-1; //If nothing is selected

            switch (choice) {
                case 1:
                    System.out.println("Enter loan name:");
                    String loan_name = scanner.nextLine();
                     System.out.println("Enter loan id:");
                    int loan_id = scanner.nextInt();
                      System.out.println("Enter loan amount:");
                    int amount = scanner.nextInt();
                    Customer c=new Customer();
                    Manager m =new Manager();
                    loanId=c.SearchLoan();
                    m.addLoan(loan_name,loan_id,amount);
                    break;
                case 2:
                    Approval a=new Approval();
                    a.generateLoanReport();
                    
                    break;
                case 3:
                    System.out.println("Logging out...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Disconnected from database.");
            } catch (SQLException e) {
                System.out.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}


