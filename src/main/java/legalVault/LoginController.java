package legalVault;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import com.password4j.Argon2Function;
import com.password4j.Hash;
import com.password4j.Password;
import com.password4j.types.Argon2;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController implements Initializable
{

    @FXML
    private Text actionTarget;
	
	@FXML
    private Button close;

    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    public static String currentUsername;
    
    public void loginClicked() throws IOException {
    	actionTarget.setId("actionTarget");
      LoginStatus status = null;
      try {
          status =login(Connector.getDBConnection(), username.getText(), password.getText());
      } catch (Exception e) {
          throw new RuntimeException(e);
      }
      switch (status)
      {
          case WrongPassword: actionTarget.setText("Wrong Password"); break;
          case UserNotFound: actionTarget.setText("User not found"); break;
          case CorrectPassword:
              actionTarget.setText("Correct Password");
              currentUsername = username.getText();
              loginBtn.getScene().getWindow().hide();
              Parent root= FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
              Stage stage=new Stage();
              Scene scene=new Scene(root,1100,600);
              stage.initStyle(StageStyle.TRANSPARENT);
              stage.setScene(scene);
              stage.show();
              break;
         default:
        	 break;
      }
	}

    public void registerClicked()
    {
        actionTarget.setId("actionTarget");
        LoginStatus status = null;
        try {
            status = register(Connector.getDBConnection(), username.getText(), password.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        switch (status)
        {
            case UserCreated: actionTarget.setText("Registration Successful"); break;
            case UserAlreadyExists: actionTarget.setText("User already exists. Try Logging in"); break;
            default:
                break;
        }
    }

    public static LoginStatus register(Connection connection, String username, String password) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet rs;

        rs = statement.executeQuery(String.format("SELECT * FROM CREDENTIALS WHERE USERNAME = \"%s\"", username));
        if (rs.next()) return LoginStatus.UserAlreadyExists;

        Argon2Function argon2 = Argon2Function.getInstance(1024, 3, 2, 16, Argon2.D, 19);
        Hash hash = Password.hash(password).with(argon2);
        String encryptedPass = hash.getResult();
        System.out.println(encryptedPass);

        statement.executeUpdate(String.format("INSERT INTO CREDENTIALS VALUE (\"%s\", \"%s\")", username, encryptedPass));
        connection.commit();
        return LoginStatus.UserCreated;
    }

    public static LoginStatus login(Connection connection, String username, String password) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet rs;

        rs = statement.executeQuery(String.format("SELECT * FROM CREDENTIALS WHERE USERNAME = \"%s\"", username));
        if (!rs.next()) return LoginStatus.UserNotFound;

        Argon2Function argon2 = Argon2Function.getInstance(1024, 3, 2, 16, Argon2.D, 19);
        return Password.check(password, rs.getString("password")).with(argon2) ? LoginStatus.CorrectPassword : LoginStatus.WrongPassword;
    }
    
    public void close(){
        System.exit(0);
    }


    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}