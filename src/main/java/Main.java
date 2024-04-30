import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Создаем книгу
        Book book = new Book("№123", "Василий Неумеха", "Мои странные мемуары");
//        System.out.println("Название книги: " + book.getTitle());
//        System.out.println("Автор: " + book.getAuthor());
//        System.out.println("Инвентарный номер: " + book.getInventoryNumber());

        // Создаем журнал
        Journal journal = new Journal("№342", "Петр Сумбурный", "В поисках сокровищ");
        Journal journal2 = new Journal("№359", "Петр Сумбурный", "Сокровищ больше нет!");
//        System.out.println("\nНазвание журнала: " + journal.getJournalName());
//        System.out.println("Автор: " + journal.getAuthor());
//        System.out.println("Инвентарный номер: " + journal.getInventoryNumber());

        // Используем интерфейс
        LibraryRegistryImpl libraryRegistry = new LibraryRegistryImpl();
        libraryRegistry.add(book);
        libraryRegistry.add(journal);
        libraryRegistry.add(journal2);

        // Поиск по номеру
        AbstractItem foundItem = libraryRegistry.findByInventoryNumber("№123");
        if (foundItem != null) {
            System.out.println("Книга найдена: " + foundItem.getAuthor());
        } else {
            System.out.println("Книга не найдена");
        }

        // Поиск по автору
        List<AbstractItem> itemsByAuthor = libraryRegistry.findByAuthor("Петр Сумбурный");
        if (itemsByAuthor.isEmpty()) {
            System.out.println("Автор и его книги не найдены!");
        } else {
            System.out.println("Найдены следующие инвентарные номера данного Автора: ");
            for (AbstractItem item: itemsByAuthor) {
                System.out.println(item.getInventoryNumber());
            }
        }
    }
}
