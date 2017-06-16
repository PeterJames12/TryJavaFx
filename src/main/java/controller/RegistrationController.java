package controller;

import email.EmailConfig;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
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
        btnSubmit.setOnAction(e -> sendEmail());
    }

    private void sendEmail() {
        List<String> list = new LinkedList<>();
        list.add(txtEmail.getText());
        list.add(txtPassword.getText());
        list.add(txtName.getText());
        list.add(date.getValue().toString());

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(txtEmail.getText());
        message.setFrom("summerjava570@gmail.com");

        message.setText(list.toString());
        message.setSubject("Java Kids");
        EmailConfig emailConfig = new EmailConfig();
        JavaMailSenderImpl javaMailSender = emailConfig.mailSender();
        javaMailSender.send(message);
    }
}
