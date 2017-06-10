package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 6/10/17.
 */
public class IteaController implements Initializable {

    @FXML
    public Button btnHello;

    public void initialize(URL location, ResourceBundle resources) {
        btnHello.setOnAction(e -> printHello());
    }

    private void printHello() {
        System.out.println("Hello");
    }
}
