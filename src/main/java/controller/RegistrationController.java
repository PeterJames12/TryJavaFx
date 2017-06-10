package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 6/10/17.
 */
public class RegistrationController implements Initializable {

    @FXML
    public Button btnSubmit;
    @FXML
    public DatePicker date;
    @FXML
    public TextField txtName;
    @FXML
    public TextField txtEmail;
    @FXML
    public PasswordField txtPassword;


    public void initialize(URL location, ResourceBundle resources) {
        btnSubmit.setOnAction(e -> printValues());
    }

    private void printValues() {
        System.out.println(txtName.getText());
        System.out.println(txtEmail.getText());
        System.out.println(txtPassword.getText());
        System.out.println(date.getValue());
    }
}
