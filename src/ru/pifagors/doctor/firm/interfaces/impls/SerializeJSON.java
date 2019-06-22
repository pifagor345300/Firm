package ru.pifagors.doctor.firm.interfaces.impls;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeJSON {
    private static String path = ".\\TEMP\\json.dat";

    public static ObservableList<Person> serRead (){
        ObservableList<Person> observableList = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            ArrayList<Person> arrayList = mapper.readValue(new File(path), new TypeReference<List<Person>>() {
            });
            observableList = FXCollections.observableList(arrayList);
        } catch (Exception e) {
            // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file!");

            alert.showAndWait();
        }
        return observableList;
    }

    public static void serWrite(ObservableList<Person> observableList){
        try {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Person> arrayList = new ArrayList<>(observableList);
        mapper.writeValue(new File(path), arrayList);
        } catch (Exception e) { // catches ANY exception
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file!");

            alert.showAndWait();
        }
    }
}
