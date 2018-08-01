package schoolsystem;


import Admin.AdminController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;


public class LoginController implements Initializable {
    LoginModel loginModel=new LoginModel();
    
    @FXML
    private Label dbstatus;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private ComboBox<option> combobox;
    @FXML
    private Button loginbutton;
    
    @FXML
    private Label loginstatus;
    @Override
    public void initialize(URL url,ResourceBundle rb){
        if(this.loginModel.isDatabaseConnected()){
            this.dbstatus.setText("Connected to Database");
        }
        else{
            this.dbstatus.setText("NotConnceted to Database");
            }
        this.combobox.setItems(FXCollections.observableArrayList(option.values()));
    
}
    
    
    @FXML
    public void Login(ActionEvent event){
        try{
                if(this.loginModel.isLogin(this.username.getText(),this.password.getText(),(this.combobox.getValue()).toString()))
                    {
                    Stage stage=(Stage)this.loginbutton.getScene().getWindow();
                    stage.close();
                    switch(((option)this.combobox.getValue()).toString()){
                        case "Admin":
                                        adminLogin();
                                         break;
                        case"Student":
                                        studentLogin(); 
                                        break;
                    
                        
                                                }
                    
                    }
                else{
                 this.loginstatus.setText("Wrong Credential");
                    }
        
            }
        catch(Exception localException){
            
        }
    }
    
    
    public void studentLogin(){
        try{
            Stage userStage=new Stage();
            FXMLLoader loader=new FXMLLoader();
            Pane root=(Pane)loader.load(getClass().getResource("/students/students.fxml").openStream());
            
            
           
            StudentsController studentController=(StudentsController)loader.getController();
            
            Scene scene =new Scene(root);
            userStage.setScene(scene);
            userStage.setTitle("Student Dashboard");
            userStage.setResizable(false);
            userStage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
              
    }
    }
    
    
    
    public void adminLogin(){
        try{
            Stage adminStage=new Stage();
            FXMLLoader adminLoader=new FXMLLoader();
            Pane adminroot=(Pane)adminLoader.load(getClass().getResource("/Admin/Admin.fxml").openStream());
            AdminController adminController=(AdminController)adminLoader.getController();
            
            Scene scene=new Scene(adminroot);
            
            adminStage.setScene(scene);
            adminStage.setTitle("Admin Dasboard");
            
            adminStage.setResizable(false);
            adminStage.show();
            
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
}
}
