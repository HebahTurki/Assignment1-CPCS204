package EmployeeAssignment;

import java.util.*;
import java.io.*;

/*
 Name : Hebah Turki Alahmari 
 IDs : 2105304
 Section : B9B
 Email: hmohammadalahmari@stu.kau.edu.sa
 Assignment#1
 */

public class MainProgram 
{
    
    //method for printing all the info in the linkedList
    public static void displayAllCenters(PrintWriter pinFile, Center[] centerArray) 
    {
        for (int i = 0; i < centerArray.length; i++) //for loop for geting the linkedList
        {
            pinFile.println("                                Employees in  "+centerArray[i].getCenterName()+" Center				");
            pinFile.println("	ID	        Name 	                      Product 	");
            
            Employee helpPtr = centerArray[i].getHead();
            while(helpPtr != null) //loop for traversing in the linkedList and print the info
            {
                String fullName = helpPtr.getFname()+" "+helpPtr.getLname();
                pinFile.printf("      %-14s%-32s%s\n",helpPtr.getEmpID(),fullName, helpPtr.getProduct());
                helpPtr = helpPtr.getNext();
            }
            pinFile.println("                   ----------------------------------------------				");
        }
        
    }
    
    //method to add the info in the linkedList
    public static Center[] startUp(Scanner inputFile1) 
    {
        int numOfEmp = inputFile1.nextInt();
        int numOfCenter = inputFile1.nextInt();
        int numOfProduct = inputFile1.nextInt();
        
        Center[] centerArray = new Center[numOfCenter];
        for(int i =0; i < centerArray.length; i++)
        {
            String Cname = inputFile1.next();//read the Center name from the file
            centerArray[i] = new Center(Cname);
        }
        
        String[] productArray = new String[numOfProduct];
        for(int i =0; i < productArray.length; i++)
        {
            productArray[i] = inputFile1.next();//read the product name from the file
        }
        //fill the linkedlists
        for(int i =0; i < centerArray.length; i++)
        {
            //create the node"data part"for the linkedlists for each center
            for (int j = 0; j < 5; j++) 
            {
                String ID = inputFile1.next();
                String fname = inputFile1.next();
                String lname = inputFile1.next();
                String product = productArray[j];
                
                centerArray[i].addEmployee(ID, fname, lname, product);
            }
        }
        
        for (int i = 0; i < numOfCenter; i++) 
        {
            int ID = inputFile1.nextInt();//read the ID
            String centerName = inputFile1.next();//read centerName
            
            centerArray[i].setCenterID(ID);
        }
        
        return centerArray;
    }
    
    //method for printing the info of employee in the linkedList by the product
    public static void displayProductForEmp(PrintWriter pinFile, Scanner inputFile2, Center[] centerArray) 
    {
        String ID = inputFile2.next();
        int count = 0;
        
        for (int i = 0; i < centerArray.length; i++) 
        {
            Employee Emp = centerArray[i].searchEmployeeByID(ID);//search for the employee by the ID
            
            //printing
            if(Emp != null)
            {
                pinFile.println("	\"Employee: "+Emp.getFname()+" "+Emp.getLname()+", "+Emp.getEmpID()+", is assigned to "+Emp.getProduct()+", in "+centerArray[i].getCenterName()+" center  \"			");
                break;
            }
            
            if(Emp == null)
            {
                count++;
            }
            
        }
        
        if(count == centerArray.length)
        {
            pinFile.println("	No employee of this number is found			");
            pinFile.println("-------------------------------------------------------------------------------				\n");
        }
        
    }
    
    //method for display the number of employee in the Center
    public static void numOfEmp(PrintWriter pinFile, Scanner inputFile2, Center[] centerArray) 
    {
        String Cname = inputFile2.next();
        
        for (int i = 0; i < centerArray.length; i++) 
        {
            if(centerArray[i].getCenterName().equals(Cname))
            {
                int count = 0;
                Employee helpPtr = centerArray[i].getHead();
                
                while(helpPtr != null)//travers in the linkedlist
                {
                    count++;
                    helpPtr = helpPtr.getNext();
                }
                
                pinFile.println("                   Number of employess in "+centerArray[i].getCenterName()+" center: "+count+"				");
                
                break;
            }
        }

    }
    
    //method for printing all the info of employee in the linkedList based on product
    public static void displayOnProduct(PrintWriter pinFile, Scanner inputFile2, Center[] centerArray) 
    {
        String Pname = inputFile2.next();//reading the product name
        
        pinFile.println("\n                              Employees for Product "+Pname+"				");
        pinFile.println("	ID	Name 	                    Center 	");

        
        for (int i = 0; i < centerArray.length; i++) 
        {
            
            Employee helpPtr = centerArray[i].getHead();
            while(helpPtr != null)//travers
            {
                if (helpPtr.getProduct().equals(Pname)) //search for the employee with the same product
                {
                    String FullName = helpPtr.getFname()+" "+helpPtr.getLname();
                    pinFile.printf("      %-8s%-26s%s\n",helpPtr.getEmpID(), FullName, centerArray[i].getCenterName());
                }
                helpPtr = helpPtr.getNext();
            }
        }
        
    }
    
    //method for delete the chosen product from the selected employee
    public static void deleteProduct(PrintWriter pinFile, Scanner inputFile2, Center[] centerArray) 
    {
        String ID = inputFile2.next();
        pinFile.println("==========================================================================				");

        for (int i = 0; i < centerArray.length; i++) 
        {
            Employee Emp = centerArray[i].searchEmployeeByID(ID);
            if (Emp != null) //when the employee found delete the product
            {
                Emp.setProduct(null);
                
                pinFile.println("                                  Change Assigned Product to Null 				");
                pinFile.println("	Products for  "+Emp.getFname()+" "+Emp.getLname()+"  : "+Emp.getEmpID()+" has been changed to null			");
                pinFile.println("");
                
                break;
            }
        }
    }
    
    //method for swaping the full name and ID 
    public static void swapEmp(PrintWriter pinFile, Scanner inputFile2, Center[] centerArray) 
    {
        //take the two ID
        String EmpID1 = inputFile2.next();
        String EmpID2 = inputFile2.next();
        
        //search for the object
        Employee Emp1 = null;
        String Cname1 = null;
        for (int i = 0; i < centerArray.length; i++) 
        {
            if (Emp1 == null) 
            {
                Emp1 = centerArray[i].searchEmployeeByID(EmpID1);
                Cname1 = centerArray[i].getCenterName();
            }
            else
            {
                break;
            }    
        }
        
        Employee Emp2 = null;
        String Cname2 = null;
        for (int i = 0; i < centerArray.length; i++) 
        {
            if (Emp2 == null) 
            {
                Emp2 = centerArray[i].searchEmployeeByID(EmpID2);
                Cname2 = centerArray[i].getCenterName();
            }
            else
            {
                break;
            }    
        }
        
        //swap it and print
        Center.swapEmployees(Emp1, Emp2);
        pinFile.println("===========================================================================				\n" +
                        "                           Swap Centers Between Two Employees ");
        pinFile.println("	"+Emp2.getFname()+" "+Emp2.getLname()+" in "+Cname1+" center is SWAPED WITH  "+Emp1.getFname()+" "+Emp1.getLname()+" in "+Cname2+" center 			");
        pinFile.println();
        pinFile.println("============================================================================				\n\n");
        
    }
    
    public static void main(String[] args) throws FileNotFoundException 
    {
        //Open the input Files & reading the data.
        File inputInfo = new File("intialInformation.txt");
        File inputCommands = new File("Commands.txt");
        
        //File pointer to the output file.
        File outputInfo = new File("Output.txt");
        
        //Check if the files exists.
        if(!inputInfo.exists() || !inputCommands.exists())
        {
            System.out.println("The input files does not exists!!");
            System.exit(0);
        }
        
        //Make Scanners for input Files.
        Scanner inputFile1 = new Scanner(inputInfo);
        Scanner inputFile2 = new Scanner(inputCommands);
        
        //Creating fileWriter to write in the File.
        PrintWriter pinFile = new PrintWriter(outputInfo);
        
        
        Center[] centerArray = null;
        
        String command;
        
        pinFile.println("                                                  Welcome to Shopping Center Employee Management System 				\n" +
                        "                                                  ---------------------------------------------------------------------------				");
        do
        {
            command = inputFile2.next();
            
            if(command.equals("QUIT"))
                break;
            
            switch(command)
            {
                case "STARTUP" :
                    centerArray = startUp(inputFile1);
                    break;
                    
                case "DISPLAY_ALL_CENTERS" :
                    
                    pinFile.println("                                                                         Information of Employees in Each Center \n");
                    
                    displayAllCenters(pinFile,centerArray);
                    break;
                    
                case "DISPLAY_PRODUCTS_FOR_EMPLOYEE" :
                    displayProductForEmp(pinFile, inputFile2, centerArray);
                    break; 
                
                case "NUM_OF_EMPLOYEES" :
                    numOfEmp(pinFile, inputFile2, centerArray);
                    break;
                    
                case "DISPLAY_BASED_ON_PRODUCT" :
                    displayOnProduct(pinFile, inputFile2, centerArray);
                    break;    
                    
                case "CHANGE_TO_NULL_PRODUCT" :
                    deleteProduct(pinFile, inputFile2, centerArray);
                    break;
                    
                case "SWAP_BETWEEN_EMPLOYEES" :
                    swapEmp(pinFile, inputFile2, centerArray);
                    break;      
                 
            }

            
        }while(inputFile2.hasNext());
        
        pinFile.println();
        pinFile.println();
        pinFile.println();
        pinFile.println();
        pinFile.println("	============================			\n" +
"		Best Wishes 		\n" +
"	============================");
        

        
        //close the file writer
        pinFile.close();
    }



}
