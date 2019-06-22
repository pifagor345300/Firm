package ru.pifagors.doctor.firm.objects;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import javafx.beans.property.SimpleStringProperty;

import static com.fasterxml.jackson.annotation.JsonCreator.Mode.DEFAULT;
@JsonAutoDetect
public class Person {

    private SimpleStringProperty department = new SimpleStringProperty("");
    private SimpleStringProperty address = new SimpleStringProperty("");
    private SimpleStringProperty fio = new SimpleStringProperty("");
    private SimpleStringProperty phone = new SimpleStringProperty("");
    private SimpleStringProperty email = new SimpleStringProperty("");

    public Person() {
    }

    public Person(String department, String address, String fio, String phone, String email) {
        this.department = new SimpleStringProperty(department);
        this.address = new SimpleStringProperty(address);
        this.fio = new SimpleStringProperty(fio);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getFio() {
        return fio.get();
    }

    public void setFio(String fio) {
        this.fio.set(fio);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public SimpleStringProperty departmentProperty() {return department;}

    public SimpleStringProperty addressProperty() {return address;}

    public SimpleStringProperty fioProperty() {return fio;}

    public SimpleStringProperty phoneProperty() {return phone;}

    public SimpleStringProperty emailProperty() {return email;}

    @Override
    public String toString() {
        return "Person{" +
                "department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
