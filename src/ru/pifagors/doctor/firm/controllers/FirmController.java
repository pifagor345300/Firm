/*Контроллер формы для клиента*/
package ru.pifagors.doctor.firm.controllers;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.IOException;

public class FirmController {

    private CollectionFirm firmImpl = new CollectionFirm();

    @FXML
    private TextField txtSearch;

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
        updateCountLabel();
        tableFirm.setItems(firmImpl.getPersonList());



    }

    private void updateCountLabel() throws IOException, ClassNotFoundException {

        labelCount.setText("Number of entries: "+ firmImpl.getPersonList().size());
    }
}
