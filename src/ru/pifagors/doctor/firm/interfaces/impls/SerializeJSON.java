package ru.pifagors.doctor.firm.interfaces.impls;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeJSON {
    private static String path = ".\\TEMP\\json.dat";

    public static ObservableList<Person> serRead () throws IOException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Person> arrayList = mapper.readValue(new File(path), new TypeReference<List<Person>>(){});
        ObservableList<Person> observableList = FXCollections.observableList(arrayList);
        return observableList;
    }

    public static void serWrite(ObservableList<Person> observableList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Person> arrayList = new ArrayList<>(observableList);
        mapper.writeValue(new File(path), arrayList);
    }
}
