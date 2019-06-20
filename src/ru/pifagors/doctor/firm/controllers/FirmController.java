/*Контроллер формы для клиента*/
package ru.pifagors.doctor.firm.controllers;

import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.IOException;
import java.lang.reflect.Method;

public class FirmController {

    private CollectionFirm firmImpl = new CollectionFirm();

    private ObservableList<Person> backupList;

    @FXML
    private CustomTextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private TableView tableFirm;

    @FXML
    private Label labelCount;

    @FXML
    private TableColumn<Person, String> columnAPT;

    @FXML
    private TableColumn<Person, String> columnAdres;

    @FXML
    private TableColumn<Person, String> columnFIO;

    @FXML
    private TableColumn<Person, String> columnPhone;

    @FXML
    private TableColumn<Person, String> columnEMail;

    @FXML
    private void initialize() throws IOException, ClassNotFoundException {
        columnAPT.setCellValueFactory(new PropertyValueFactory<Person, String>("department"));
        columnAdres.setCellValueFactory(new PropertyValueFactory<Person, String>("address"));
        columnFIO.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        columnEMail.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        setupClearButtonField(txtSearch);
        firmImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                try {
                    updateCountLabel();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        firmImpl.fillData();
        //backup
        backupList = FXCollections.observableArrayList();
        backupList.addAll(firmImpl.getPersonList());
        updateCountLabel();
        tableFirm.setItems(firmImpl.getPersonList());


    }

    private void updateCountLabel() throws IOException, ClassNotFoundException {

        labelCount.setText("Number of entries: " + firmImpl.getPersonList().size());
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionSearch(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        firmImpl.getPersonList().clear();

        for (Person person : backupList) {
            if (person.getDepartment().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    person.getAddress().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    person.getFio().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    person.getPhone().toLowerCase().contains(txtSearch.getText().toLowerCase()) ||
                    person.getEmail().toLowerCase().contains(txtSearch.getText().toLowerCase())) {
                firmImpl.getPersonList().add(person);
            }
        }
        updateCountLabel();

    }
}
