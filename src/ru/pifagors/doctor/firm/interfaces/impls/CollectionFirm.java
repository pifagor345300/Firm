package ru.pifagors.doctor.firm.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.pifagors.doctor.firm.interfaces.Firm;
import ru.pifagors.doctor.firm.objects.Person;

import static javafx.collections.FXCollections.observableList;


// Временно реализовываем класс с помощью коллекции
public class CollectionFirm implements Firm {
    private ObservableList<Person> personList = FXCollections.observableArrayList();


    @Override
    public void add(Person person) { personList.add(person);

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) { personList.remove(person);

    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }



    public  void fillTestData(){
        personList.add(new Person("АИТ","Программист","Лашманов","7777777","ait@mail.ru"));
        personList.add(new Person("Аптека 1","Заведующая","Набока","29-39-79","a1@mail.ru"));
        personList.add(new Person("Аптека 10","Заведующая","Сенькина","29-39-87","a10@mail.ru"));
        personList.add(new Person("ГУП РК ГАРК","Ген. директор","Лейбов","29-39-29","dir@mail.ru"));
        personList.add(new Person("АИТ","Нач отдела","Емельянов","29-39-100","ait1@mail.ru"));
    }
}
