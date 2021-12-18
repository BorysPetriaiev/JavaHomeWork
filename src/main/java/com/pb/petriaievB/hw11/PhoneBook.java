package com.pb.petriaievB.hw11;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.util.*;
import java.time.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhoneBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать в телефонный справочник!");
        System.out.println("Для добавления контакта введите '1'");
        System.out.println("Для поиска введите '2'");
        System.out.println("Для удаления контакта введите '3'");
        System.out.println("Для отображения списка контактов введите '4'");
        System.out.println("Для сортировки по ФИО введите '5'");
        System.out.println("Для сортировке по дате рождения введите '6'");
        System.out.println("Для редактирования пользователя введите '7");
        System.out.println("Для вывода книги в JSON введите '8'");
        System.out.println("Для запись в книгу из JSON введите '9'");
        System.out.println("Для выхода введите '0'");
        int input = scan.nextInt();
        boolean run = true;
        while (run) {
            switch (input) {
                case 1:
                    phoneBook.Add();
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 2:
                    System.out.println(phoneBook.Search());
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 3:
                    phoneBook.Remove();
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 4:
                    System.out.println(phoneBook.showPhoneBook());
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 5:
                    System.out.println(phoneBook.SortByDateOfBirth());
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                case 6:
                    System.out.println(phoneBook.SortByName());
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 7:
                    phoneBook.Modify();
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 8:
                    phoneBook.writeFile();
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 9:
                    phoneBook.readFile();
                    System.out.println("Введите новый запрос: ");
                    input = scan.nextInt();
                    break;
                case 0:
                    run = false;
                    System.out.println("До встречи!");
                    break;
                default:
                    System.out.println("Неверный запрос. Попробуйте снова.");
                    input = scan.nextInt();
                    break;
            }
        }
    }
    private List<Contact> phoneBook = new ArrayList<>();
    public void Add() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ФИО: ");
            String name = scan.nextLine();
            System.out.println("Введите адрес: ");
            String address = scan.nextLine();
            System.out.println("Сколько у пользователя номеров?");
            int size = scan.nextInt();
            scan.nextLine();
            if (size <= 0)
                throw new IllegalArgumentException();
            String[] phones = new String[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Введите номер:");
                phones[i] = scan.nextLine();
            }
            System.out.println("Поочередно введите день, месяц и год рождения: ");
            int day = scan.nextInt();
            int month = scan.nextInt();
            int year = scan.nextInt();
            phoneBook.add(new Contact(name, address, phones, LocalDate.of(year, month, day), LocalDateTime.now()));
        } catch (Exception e) {
            System.err.println("Ошибка создания пользователя.");
        }
    }
    public String showPhoneBook() {
        return phoneBook.toString();
    }
    public void Remove() {
        Scanner scan = new Scanner(System.in);
        try {
            // алгоритм аналогичен Search()
            System.out.println("Введите ФИО для удаления контакта: ");
            String str = scan.nextLine();
            String[] ph = new String[1];
            Contact def = new Contact(str, "default", ph,
                    LocalDate.of(1970, 1, 1), LocalDateTime.now());
            for (int i = 0; i < phoneBook.size(); i++) {
                if (phoneBook.get(i).getName().equals(def.getName()))
                    phoneBook.remove(i);
                System.out.println("Контакт успешно удалён!");
            }
        } catch (Exception e) {
            System.err.println("Ошибка удаления пользователя.");
        }
    }
    public String Search() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ФИО для поиска: ");
        String str = scan.nextLine();
        String[] p = new String[0];
        Contact def = new Contact(str, "default", p,
                LocalDate.of(1970, 1, 1), LocalDateTime.now());
        for (int i = 0; i < phoneBook.size(); i++) {
            if (phoneBook.get(i).getName().equals(def.getName()))
                return phoneBook.get(i).toString();
        }
        return "Пользователь не найден.";
    }
    public void Modify() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите ФИО пользователя для редактирования: ");
            String[] p = new String[0];
            String str = scan.nextLine();
            Contact def = new Contact(str, "default", p,
                    LocalDate.of(1970, 1, 1), LocalDateTime.now());
            for (int i = 0; i < phoneBook.size(); i++) {
                if (phoneBook.get(i).getName().equals(def.getName())){
                    System.out.println("Пользователь найден.");
                    System.out.println(phoneBook.get(i));
                    System.out.println("Для изменения ФИО введите 'name'");
                    System.out.println("Для изменения адреса введите 'address'");
                    System.out.println("Для изменения даты рождения введите 'date'");
                    System.out.println("Для изменения номера введите 'phone'");
                    String choice = scan.nextLine();
                    LocalDateTime changes = LocalDateTime.now();
                    switch (choice) {
                        case "name":
                            System.out.println("Введите новое ФИО: ");
                            String newName = scan.nextLine();
                            phoneBook.get(i).setName(newName);
                            phoneBook.get(i).setLastChanges(changes);
                            System.out.println("ФИО успешно изменено!");
                            break;
                        case "address":
                            System.out.println("Введите новый адрес: ");
                            String newAdress = scan.nextLine();
                            phoneBook.get(i).setAddress(newAdress);
                            phoneBook.get(i).setLastChanges(changes);
                            System.out.println("Адрес успешно изменен!");
                            break;
                        case "phone":
                            System.out.println("Сколько номеров у пользователя?");
                            int size = scan.nextInt();
                            for (int n = 0; n < size; n++) {
                                System.out.println("Введите номер: ");
                                scan.nextLine();
                                System.out.println("Номер успешно изменён");
                            }
                            break;
                        case "date":
                            System.out.println("Введите поочередно день, месяц и год рождения: ");
                            int dd = scan.nextInt();
                            int mm = scan.nextInt();
                            int yy = scan.nextInt();
                            phoneBook.get(i).setBorn(yy, mm, dd);
                            phoneBook.get(i).setLastChanges(changes);
                            System.out.println("Дата рождения успешно изменена!");
                            break;
                        default:
                            System.out.println("Неверный запрос.");
                            break;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка редактирования пользователя.");
        }
    }
    public String SortByDateOfBirth() {
        Comparator<Contact> cmp = (p1, p2) ->
                p1.getBorn().compareTo(p2.getBorn());
        phoneBook.sort(cmp);
        return phoneBook.toString();
    }
    public String SortByName() {
        Comparator<Contact> cmp = (p1, p2) ->
                p1.getName().compareTo(p2.getName());
        phoneBook.sort(cmp);
        return phoneBook.toString();
    }
    public void writeFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            mapper.registerModule(module);
            Path file = Files.createFile(Paths.get("phonebook.json"));
            String json = mapper.writeValueAsString(phoneBook);
            try (BufferedWriter wr = Files.newBufferedWriter(file)) {
                wr.write(json);
                System.out.println("Данные успешно экспортированы!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readFile() {
        try {
            File file = Paths.get("phonebook.json").toFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            SimpleModule module = new SimpleModule();
            module.addSerializer(LocalDate.class, new LocalDateSerializer());
            module.addDeserializer(LocalDate.class, new LocalDateDeserializer());
            module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
            module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer());
            mapper.registerModule(module);
            List<Contact> contactList = mapper.readValue(file, new TypeReference<List<Contact>>() {});
            phoneBook.addAll(contactList);
            System.out.println("Данные успешно импортированы!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}