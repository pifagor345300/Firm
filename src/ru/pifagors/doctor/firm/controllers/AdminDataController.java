/*Контроллер модальной формы добавления, изменения информации*/
package ru.pifagors.doctor.firm.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.pifagors.doctor.firm.interfaces.impls.CollectionFirm;
import ru.pifagors.doctor.firm.interfaces.impls.SerializeJSON;
import ru.pifagors.doctor.firm.objects.Person;



public class AdminDataController {

    @FXML
    private Button btnOk;

    @FXML
    private Button btnEsc;

    @FXML
    private TextField txtAptOtd;

    @FXML
    private TextField txtAdrDol;

    @FXML
    private TextField txtFio;

    @FXML
    private TextField txtPhone;

    @FXML
    private TextField txtEMail;

    private Person person;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node)  actionEvent.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void setPerson(Person person) {
        this.person = person;

        txtAptOtd.setText(person.getDepartment());
        txtAdrDol.setText(person.getAddress());
        txtFio.setText(person.getFio());
        txtPhone.setText(person.getPhone());
        txtEMail.setText(person.getEmail());
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setDepartment(txtAptOtd.getText());
        person.setAddress(txtAdrDol.getText());
        person.setFio(txtFio.getText());
        person.setPhone(txtPhone.getText());
        person.setEmail(txtEMail.getText());
        actionClose(actionEvent);
//        AdminFirmController.firmImpl.update(AdminFirmController.index, person);


    }

    public Person getPerson() {
        return person;
    }


}
