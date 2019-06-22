/*Контроллер формы для администрирования*/
package ru.pifagors.doctor.firm.controllers;


import javafx.beans.property.ObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
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
import javafx.stage.Window;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.objects.Person;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ResourceBundle;

public class AdminFirmController {

    static CollectionFirm firmImpl = new CollectionFirm();

    static int index;

    private ObservableList<Person> backupList;

    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader = new FXMLLoader();

    private AdminDataController editDialogController;

    private Stage editDialogStage;

    private Stage mainStage;

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    private CustomTextField txtSearch;

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

        setupClearButtonField(txtSearch);
        firmImpl.fillData();
        backupList = FXCollections.observableArrayList();
        backupList.addAll(firmImpl.getPersonList());
        updateCountLabel();
        tableFirm.setItems(firmImpl.getPersonList());

        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/adminData.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void updateCountLabel() throws IOException, ClassNotFoundException {
        labelCount.setText("Number of entries: "+ firmImpl.getPersonList().size());
    }

    private void setupClearButtonField(CustomTextField customTextField) {
        try {
            Method m = TextFields.class.getDeclaredMethod("setupClearButtonField", TextField.class, ObjectProperty.class);
            m.setAccessible(true);
            m.invoke(null, customTextField, customTextField.rightProperty());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public void actionButtonPressed(ActionEvent actionEvent) throws IOException {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButtun = (Button) source;

        Person selectedPerson = (Person) tableFirm.getSelectionModel().getSelectedItem();
        index = tableFirm.getSelectionModel().getFocusedIndex();

        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();

        editDialogController.setPerson(selectedPerson);

        switch (clickedButtun.getId()) {
            case "btnAdd":
                System.out.println("Add " + selectedPerson);
                editDialogController.setPerson(new Person());
                showDialog();
                firmImpl.add(editDialogController.getPerson());
                break;
            case "btnEdit":
                System.out.println("Edit " + selectedPerson);
                showDialog();
                firmImpl.update(index, selectedPerson);
                break;
            case "btnDel":
                System.out.println("Del " + selectedPerson);
                firmImpl.delete(selectedPerson);

                break;
        }


    }

    private void showDialog() {
        if (editDialogStage==null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Editing");
            editDialogStage.setMinWidth(700);
            editDialogStage.setMinHeight(300);
            editDialogStage.setResizable(false);
            Scene scene = new Scene(fxmlEdit);
            scene.getStylesheets().add(0, "ru/pifagors/doctor/firm/styles/firm.css");
            editDialogStage.setScene(scene);
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait();

    }

    public void actionSearch() throws IOException, ClassNotFoundException {
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
