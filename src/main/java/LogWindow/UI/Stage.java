package LogWindow.UI;

import LogWindow.DBWork.Connector;
import LogWindow.DBWork.DBWorker;
import LogWindow.DBWork.DBWorking;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;

public class Stage extends Application {

    private javafx.stage.Stage primaryStage;
    public static Stage stage;
    public static DBWorking dbWorking;

    @Override
    public void start(javafx.stage.Stage primaryStage) throws Exception {
        Connector connector = new Connector();
        try {
            connector.connect();
        }catch (Exception e){
            System.out.println("Невозможно подключиться к БД!");
            System.exit(1);
        }
        dbWorking = new DBWorker(connector.getConnection());
        stage = this;
        this.primaryStage = primaryStage;
        setScene(Scenes.MAIN);
        primaryStage.show();
    }

    public void setScene(Scenes sceneEnum){
        Group group = new Group();
        Scene scene = new Scene(group, 600, 400);
        primaryStage.setScene(scene);
        Pane pane = null;
        URL url = this.getClass().getResource(sceneEnum.toString());

        try {
            pane = FXMLLoader.load(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        group.getChildren().add(borderPane);
        primaryStage.setScene(scene);
    }
}

