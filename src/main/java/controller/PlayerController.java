package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Igor Hnes on 6/23/17.
 */
public class PlayerController implements Initializable {

    @FXML
    private Button btnSend;
    @FXML
    private TextField txtMessage;
    @FXML
    private MediaView mediaView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnSend.setOnAction(s -> play());
    }

    private void play() {
        if ("".equals(txtMessage.getText())) {
            return;
        }
        String music = "";
        final String txtMessageText = txtMessage.getText();

        switch (txtMessageText) {
            case "Hello":
                music = "src/main/resources/hello__original_mix_.mp3";
                break;
            case "Imagine":
                music = "src/main/resources/imagine_dragons_-_believer.mp3";
                break;
            default:
                break;
        }

        if (!(mediaView.getMediaPlayer() == null)) {
            mediaView.getMediaPlayer().stop();
        }
        String path = new File(music).getAbsolutePath();
        final Media media = new Media(new File((path)).toURI().toString());
        final MediaPlayer player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.play();
    }
}
