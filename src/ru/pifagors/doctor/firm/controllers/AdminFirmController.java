/*Контроллер формы для администрирования*/
package ru.pifagors.doctor.firm.controllers;


import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.IOException;

public class AdminFirmController {

    private CollectionFirm firmImpl = new CollectionFirm();

    @FXML
    private TextField txtSearch;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnDel;

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

        firmImpl.fillData();
        updateCountLabel();
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

        tableFirm.setItems(firmImpl.getPersonList());



    }

    private void updateCountLabel() throws IOException, ClassNotFoundException {
        labelCount.setText("Number of entries: "+ firmImpl.getPersonList().size());
    }


    public void showDialog(ActionEvent actionEvent) throws IOException {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) { return;}

        Button clickedButtun = (Button) source;

        Person selectedPerson = (Person) tableFirm.getSelectionModel().getSelectedItem();

        switch (clickedButtun.getId()){
            case "btnAdd":
                System.out.println("Add " + selectedPerson);
                break;
            case "btnEdit":
                System.out.println("Edit " + selectedPerson);
                break;
            case "btnDel":
                System.out.println("Del " + selectedPerson);
                break;
        }

        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/adminData.fxml"));
            stage.setTitle("Editing");
            stage.setMinWidth(700);
            stage.setMinHeight(300);
            stage.setResizable(false);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(0, "ru/pifagors/doctor/firm/styles/firm.css");
            stage.setScene(scene);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        };

    }
}
