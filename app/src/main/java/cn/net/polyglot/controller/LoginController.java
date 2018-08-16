package cn.net.polyglot.controller;

import cn.net.polyglot.config.Constants;
import cn.net.polyglot.net.AppService;
import cn.net.polyglot.util.Util;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetSocket;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginController {
    public TextField account;
    public PasswordField psd;
    public BorderPane loginView;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void doRegister(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("fxml/register.fxml"));
        try {
            Parent parent = loader.load();
            RegisterController controller = loader.getController();
            controller.setStage(stage);
            controller.setLoginView(loginView);
            stage.getScene().setRoot(parent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doLogin(ActionEvent actionEvent) {
        StackPane root = new StackPane();
        ImageView head = new ImageView();
        head.setImage(new Image("icons/users.png"));
        head.setFitWidth(80);
        head.setFitHeight(80);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(head);
        stage.getScene().setRoot(root);
        String user = account.getText();
        String password = psd.getText();
        AppService.get().doLogin(user,password);

    }
}
