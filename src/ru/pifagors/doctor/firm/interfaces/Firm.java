package ru.pifagors.doctor.firm.interfaces;

import ru.pifagors.doctor.firm.objects.Person;

public interface Firm {

    //Add record
    void add(Person person);
    //Make changes
    void update(int index, Person person);
    //Delete Record
    void delete(Person person);
}
