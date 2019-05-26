package ru.pifagors.doctor.firm.objects;

public class Person {

    private String department;
    private String address;
    private String fio;
    private String phone;
    private String email;

    public Person(String department, String address, String fio, String phone, String email) {
        this.department = department;
        this.address = address;
        this.fio = fio;
        this.phone = phone;
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
