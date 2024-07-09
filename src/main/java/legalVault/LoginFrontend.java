package legalVault;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginFrontend extends Application
{
   

    @Override
    public void start (Stage primaryStage) throws IOException
    {
        primaryStage.setTitle("Legal Vault");

    	
    	Parent root=FXMLLoader.load(getClass().getResource("/fxml/FXMLDocumentFrontend.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}