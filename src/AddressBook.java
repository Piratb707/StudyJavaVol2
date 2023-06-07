import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Программа записной книжки для добавления, просмотра и удаления контактов.
 */
public class AddressBook {
    private List<Contact> contacts; // Список контактов

    /**
     * Конструктор класса AddressBook.
     */
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    /**
     * Добавляет новый контакт в записную книжку.
     *
     * @param contact Контакт для добавления.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Возвращает список всех контактов в записной книжке.
     *
     * @return Список контактов.
     */
    public List<Contact> getAllContacts() {
        return contacts;
    }

    /**
     * Удаляет контакт из записной книжки.
     *
     * @param contact Контакт для удаления.
     * @return true, если контакт успешно удален, иначе false.
     */
    public boolean deleteContact(Contact contact) {
        return contacts.remove(contact);
    }

    /**
     * Главный метод программы, который демонстрирует использование записной книжки.
     *
     * @param args Аргументы командной строки (не используются).
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Просмотреть контакты");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Читаем символ новой строки после ввода числа

            switch (choice) {
                case 1:
                    System.out.println("Введите имя контакта:");
                    String name = scanner.nextLine();
                    System.out.println("Введите номер телефона контакта:");
                    String phoneNumber = scanner.nextLine();
                    Contact contact = new Contact(name, phoneNumber);
                    addressBook.addContact(contact);
                    System.out.println("Контакт успешно добавлен.");
                    break;
                case 2:
                    List<Contact> allContacts = addressBook.getAllContacts();
                    if (allContacts.isEmpty()) {
                        System.out.println("Записная книжка пуста.");
                    } else {
                        System.out.println("Контакты:");
                        for (Contact c : allContacts) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 3:
                    List<Contact> existingContacts = addressBook.getAllContacts();
                    if (existingContacts.isEmpty()) {
                        System.out.println("Записная книжка пуста.");
                    } else {
                        System.out.println("Выберите контакт для удаления:");
                        for (int i = 0; i < existingContacts.size(); i++) {
                            System.out.println((i + 1) + ". " + existingContacts.get(i));
                        }
                        int index = scanner.nextInt();
                        if (index > 0 && index <= existingContacts.size()) {
                            Contact selectedContact = existingContacts.get(index - 1);
                            if (addressBook.deleteContact(selectedContact)) {
                                System.out.println("Контакт успешно удален.");
                            } else {
                                System.out.println("Не удалось удалить контакт.");
                            }
                        } else {
                            System.out.println("Неверный выбор контакта.");
                        }
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте еще раз.");
                    break;
            }
        }

        System.out.println("Программа завершена.");
    }
}

/**
 * Класс Contact представляет контакт с именем и номером телефона.
 */
class Contact {
    private String name; // Имя контакта
    private String phoneNumber; // Номер телефона контакта

    /**
     * Конструктор класса Contact.
     *
     * @param name        Имя контакта.
     * @param phoneNumber Номер телефона контакта.
     */
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Возвращает имя контакта.
     *
     * @return Имя контакта.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает номер телефона контакта.
     *
     * @return Номер телефона контакта.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Переопределение метода toString для представления контакта в виде строки.
     *
     * @return Строковое представление контакта.
     */
    @Override
    public String toString() {
        return "Имя: " + name + ", Телефон: " + phoneNumber;
    }
}
