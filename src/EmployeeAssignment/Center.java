package EmployeeAssignment;

/**
 *
 * @author hebahturki
 */
public class Center 
{
    private String CenterName;
    private int centerID;
    private Employee head;

    public Center() 
    {
        
    }

    public Center(String CenterName) 
    {
        this.CenterName = CenterName;
    }
    
    //fill the node
    public void addEmployee(String EmpID, String Fname, String Lname, String product)
    {
        if(head == null)
        {
            head = new Employee(EmpID, Fname, Lname, product,head);
        }
        else
        {
            Employee helpPtr = head;
            while(helpPtr.getNext()!= null)
            {
                helpPtr = helpPtr.getNext();
            }
            
            helpPtr.setNext(new Employee(EmpID, Fname, Lname, product,helpPtr.getNext()));
        }
    }
    
    //searching by ID
    public Employee searchEmployeeByID(String ID)
    {
        Employee helpPtr = head;
        while(helpPtr!= null)//travers
            {
                if(helpPtr.getEmpID().equals(ID))
                    break;
                
                helpPtr = helpPtr.getNext();
            }
        return helpPtr;
    }
    
    //swap the fill name and ID
    public static void swapEmployees(Employee Emp1, Employee Emp2)
    {
        String IDEmp1 = Emp1.getEmpID();
        String FnameEmp1 = Emp1.getFname();
        String LnameEmp1 = Emp1.getLname();
        
        Emp1.setEmpID(Emp2.getEmpID());
        Emp1.setFname(Emp2.getFname());
        Emp1.setLname(Emp2.getLname());
        
        Emp2.setEmpID(IDEmp1);
        Emp2.setFname(FnameEmp1);
        Emp2.setLname(LnameEmp1);

    }
    
    //deleting the employee
    public void deleteEmployeeByID(String ID)
    {
        if(head != null)
        {
            if (head.getEmpID().equals(ID))
            {
                head = head.getNext();
            }
            else
            {
                Employee helpPtr = head;
                while(helpPtr.getNext().getNext()!= null)
                {
                    if(helpPtr.getNext().getEmpID().equals(ID))
                    {
                       helpPtr.setNext(helpPtr.getNext().getNext()); 
                       break;
                    }
                    helpPtr = helpPtr.getNext();
                }
                
            }
        }
    }

    public String getCenterName() 
    {
        return CenterName;
    }

    public void setCenterName(String CenterName) 
    {
        this.CenterName = CenterName;
    }

    public int getCenterID() 
    {
        return centerID;
    }

    public void setCenterID(int centerID) 
    {
        this.centerID = centerID;
    }

    public Employee getHead() 
    {
        return head;
    }

    public void setHead(Employee head) 
    {
        this.head = head;
    }
    
}
