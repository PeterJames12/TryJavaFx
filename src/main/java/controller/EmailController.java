package controller;

import email.EmailConfig;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 6/17/17.
 */
public class EmailController implements Initializable {

    @FXML
    public TextField txtEmail;
    @FXML
    public TextField txtSubject;
    @FXML
    public TextArea txtMessage;
    @FXML
    public Button btnSend;
    @FXML
    public ComboBox<String> programming;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        programming.setItems(FXCollections
                .observableArrayList("test", "test", "test"));
        btnSend.setOnAction(e -> sendEmail());
    }

    private void sendEmail() {
        List<String> list = new LinkedList<>();
        list.add(txtEmail.getText());
        list.add(txtSubject.getText());
        list.add(txtMessage.getText());
        list.add(programming.getSelectionModel().getSelectedItem());


        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(txtEmail.getText());
        message.setFrom("summerjava570@gmail.com");

        message.setText(list.toString());
        message.setSubject(txtSubject.getText());
        EmailConfig emailConfig = new EmailConfig();
        JavaMailSenderImpl javaMailSender = emailConfig.mailSender();
        javaMailSender.send(message);
    }
}
