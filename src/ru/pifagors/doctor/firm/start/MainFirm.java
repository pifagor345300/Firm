/*Стартовый класс для клиента. Поиск. Обновление данных при загрузке приложения*/
package ru.pifagors.doctor.firm.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainFirm extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/firm.fxml"));
        primaryStage.setTitle("State pharmacies of the Republic of Komi");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(900);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(0, "ru/pifagors/doctor/firm/styles/firm.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
