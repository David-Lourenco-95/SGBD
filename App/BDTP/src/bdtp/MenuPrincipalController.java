/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdtp;

import java.io.IOException;
import static java.lang.System.exit;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Pedro
 */
public class MenuPrincipalController implements Initializable {
    

@FXML
    private void Consulta(ActionEvent event) throws IOException {
    Parent DepartManager = FXMLLoader.load(getClass().getResource("Consulta.fxml"));
            Scene DepartManagerScene = new Scene(DepartManager);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(DepartManagerScene);
            app_stage.show();
    
    }
    
    @FXML
    private void Horario(ActionEvent event) throws IOException {
    Parent DepartManager = FXMLLoader.load(getClass().getResource("Horario.fxml"));
            Scene DepartManagerScene = new Scene(DepartManager);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(DepartManagerScene);
            app_stage.show();
    
    }
    
    @FXML
    private void Sair(ActionEvent event) {
    
    exit(0);
    }
    
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
}
