package ru.pifagors.doctor.firm.interfaces;

import ru.pifagors.doctor.firm.objects.Person;

public interface Firm {

    //Добавить запись
    void add(Person person);
    //Внести изменения
    void update(Person person);
    //Удалить запись
    void delete(Person person);
}
