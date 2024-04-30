// Абстрактный класс, описывающий объект в библиотечном фонде
abstract class AbstractItem {
    private String inventoryNumber;
    private String author;

    public AbstractItem(String inventoryNumber, String author) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
    }

    public String getInventoryNumber() {
        return inventoryNumber;
    }

    public String getAuthor() {
        return author;
    }
}
