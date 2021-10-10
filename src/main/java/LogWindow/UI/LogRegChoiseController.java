package LogWindow.UI;

import LogWindow.DBWork.DBWorking;
import LogWindow.DBWork.UserWithSalt;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.SQLException;

public class LogRegChoiseController {

    @FXML
    private Button submitButton;

    @FXML
    private CheckBox registerCheckbox;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label answerLabel;

    @FXML
    void initialize() {
        submitButton.setOnAction(event -> {

            if (registerCheckbox.isSelected()) {
                register();
            } else {
                login();
            }
        });
    }

    private void register() {
        DBWorking dbWorking = Stage.dbWorking;
        UserWithSalt user = null;
        try {
            user = dbWorking.getUser(loginTextField.getText());
        } catch (SQLException throwables) {
        }
        if (user != null) {
            answerLabel.setText("Пользователь с таким именем уже зарегестрирован!");
            answerLabel.setTextFill(Color.RED);
        } else {
            try {
                dbWorking.pushNewUser(new UserWithSalt(loginTextField.getText(), passwordField.getText(), ""));
                answerLabel.setText("Пользователь успешно зарегестрирован!");
                answerLabel.setTextFill(Color.BLUE);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
                answerLabel.setText("Проблема при добавлении пользователя!");
                answerLabel.setTextFill(Color.RED);
            }
        }
    }

    private void login() {
        DBWorking dbWorking = Stage.dbWorking;
        try {
            UserWithSalt user = dbWorking.getUser(loginTextField.getText());
            if(user != null){
                if(user.getPassword().equals(passwordField.getText())){
                    answerLabel.setText("Добро пожаловать!");
                    answerLabel.setTextFill(Color.BLUE);
                }else {
                    answerLabel.setText("Неверный пароль!");
                    answerLabel.setTextFill(Color.RED);
                }
            }
        } catch (SQLException throwables) {
            answerLabel.setText("Пользователя с таким именем не существует!");
            answerLabel.setTextFill(Color.RED);
        }
    }
}
