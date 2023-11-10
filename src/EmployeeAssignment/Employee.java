package EmployeeAssignment;

/**
 *
 * @author hebahturki
 */
public class Employee 
{
    private String EmpID;
    private String Fname;
    private String Lname;
    private String product;
    private String phone;
    private int age;
    private int center;
    private Employee next;

    public Employee(String EmpID, String Fname, String Lname, String product)
    {
        this.EmpID = EmpID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.product = product;
    }

    public Employee(String EmpID, String Fname, String Lname, String product, Employee next) 
    {
        this.EmpID = EmpID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.product = product;
        this.next = next;
    }
    
    public Employee(String EmpID, String Fname, String Lname, String product, String phone, int age, int center, Employee next) 
    {
        this.EmpID = EmpID;
        this.Fname = Fname;
        this.Lname = Lname;
        this.product = product;
        this.phone = phone;
        this.age = age;
        this.center = center;
        this.next = next;
    }

    public Employee()
    {
        
    }

    public String getEmpID() 
    {
        return EmpID;
    }

    public void setEmpID(String EmpID) 
    {
        this.EmpID = EmpID;
    }

    public String getFname() 
    {
        return Fname;
    }

    public void setFname(String Fname)
    {
        this.Fname = Fname;
    }

    public String getLname() 
    {
        return Lname;
    }

    public void setLname(String Lname) 
    {
        this.Lname = Lname;
    }

    public String getProduct() 
    {
        return product;
    }

    public void setProduct(String product) 
    {
        this.product = product;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public int getCenter()
    {
        return center;
    }

    public void setCenter(int center)
    {
        this.center = center;
    }

    public Employee getNext() 
    {
        return next;
    }

    public void setNext(Employee next) 
    {
        this.next = next;
    }
    
    
}
