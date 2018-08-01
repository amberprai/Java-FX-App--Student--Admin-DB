package students;

import Admin.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import dbUtil.dbconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController implements Initializable{
    
    
    @FXML
    private TextField id;
    @FXML
    private TextField firstname;
    
    @FXML
    private TextField lastname;
    @FXML
    private TextField email;
    @FXML
    private DatePicker dob;

    @FXML
    private TableView<StudentData> studenttable;
    
    
    @FXML
    private TableColumn<StudentData,String> idcolumn;
    
    @FXML
    private TableColumn<StudentData,String> fncolumn;
    
    @FXML
    private TableColumn<StudentData,String> lncolumn;
    
    @FXML
    private TableColumn<StudentData,String> emailcolumn;
    
    @FXML
    private TableColumn<StudentData,String> dobcolumn;
    
    
    
    private dbconnection dc;
    private ObservableList<StudentData> data;
    private String sql="Select * from students";
    
    public void initialize(URL url,ResourceBundle rb){
     this.dc=new dbconnection();
    }
    
    
    @FXML
    private void loadStudentData(ActionEvent event){
        try{
            Connection conn=dbconnection.getConnection();
            this.data=FXCollections.observableArrayList();
            
            ResultSet rs=conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new StudentData(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
                }  
            
        }
        catch(SQLException e){
            System.err.println("Error"+e);
        }
        this.idcolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("ID"));
        this.fncolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("firstname"));
        this.lncolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("lastname"));
        this.emailcolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("email"));
        this.dobcolumn.setCellValueFactory(new PropertyValueFactory<StudentData,String>("DOB"));
        
        this.studenttable.setItems(null);
        this.studenttable.setItems(this.data);
        }
    
    @FXML
    private void addStudent(ActionEvent event) throws SQLException{
        String sqlInsert="Insert into student(id,fname,lname,DOB) values (?,?,?,?,?)";
        
        try{
            Connection conn=dbconnection.getConnection();
            PreparedStatement stmt=conn.prepareStatement(sqlInsert);
            
            stmt.setString(1,this.id.getText());
            stmt.setString(2,this.firstname.getText());
            stmt.setString(3,this.lastname.getText());
            stmt.setString(4,this.email.getText());
            stmt.setString(5,this.dob.getEditor().getText());
            
            stmt.execute();
            conn.close();
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }   
        
        @FXML //clear form
        private void clearFields(ActionEvent event){
            this.id.setText("");
            this.firstname.setText("");
            this.lastname.setText("");
            this.email.setText("");
            this.dob.setValue(null);
        }
}
