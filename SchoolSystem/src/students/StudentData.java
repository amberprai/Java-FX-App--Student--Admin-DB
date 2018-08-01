package students;
import Admin.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {
    private final StringProperty ID;
    private final StringProperty firstname;
    private final StringProperty lastname;
    private final StringProperty email;
    private final StringProperty DOB;
    
    
    public StudentData(String id,String firstname , String lastname,String email,String dob){
        this.ID=new SimpleStringProperty(id);
        this.firstname=new SimpleStringProperty(firstname);
        this.lastname=new SimpleStringProperty(lastname);
        this.email=new SimpleStringProperty(email);
        this.DOB=new SimpleStringProperty(dob);
        }

    
    
    public String getID() {
        return ID.get();
    }
    
    public StringProperty IDProperty(){
        return ID;
    }

    public void setID(String ID){
        this.ID.set(ID);
        }
    
    
    public String getFirstname() {
        return firstname.get();
    }
    public StringProperty FirstnameProperty(){
        return firstname;
    }

    public void setfirstname(String Firstname){
        this.firstname.set(Firstname);
        }
    
    
    
   public String getlastname() {
        return lastname.get();
    }
    public StringProperty lastnameProperty(){
        return lastname;
    }

    public void setlasttname(String lastname){
        this.lastname.set(lastname);
        }
   

     public String getemail() {
        return email.get();
    }
    public StringProperty emailProperty(){
        return email;
    }

    public void setemail(String email){
        this.email.set(email);
        }

   
    
       public String getdob() {
        return DOB.get();
    }
    public StringProperty DOB(){
        return DOB;
    }

    public void setDOB(String DOB){
        this.DOB.set(DOB);
        }
      public StringProperty idProperty(){
          return this.ID;
          
      }
      
         
}
