/*Стартовый класс для администрирования*/
package ru.pifagors.doctor.firm.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;

import java.io.IOException;

public class MainAdmin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/adminFirm.fxml"));
        primaryStage.setTitle("State pharmacies of the Republic of Komi");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(900);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(0, "ru/pifagors/doctor/firm/styles/firm.css");
        primaryStage.setScene(scene);
        primaryStage.show();

//        runData();
    }

    private void runData() throws IOException, ClassNotFoundException { //todo Убрать наверное
        CollectionFirm firm = new CollectionFirm();
        firm.fillData();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
