/*Стартовый класс для администрирования*/
package ru.pifagors.doctor.firm.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.objects.Person;

public class MainAdmin extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/adminFirm.fxml"));
        primaryStage.setTitle("ГУП РК ГАРК");
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(900);
        Scene scene = new Scene(root);
        scene.getStylesheets().add(0, "ru/pifagors/doctor/firm/styles/firm.css");
        primaryStage.setScene(scene);
        primaryStage.show();

        testData();
    }

    private void testData(){
        CollectionFirm firm = new CollectionFirm();
        firm.fillTestData();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
