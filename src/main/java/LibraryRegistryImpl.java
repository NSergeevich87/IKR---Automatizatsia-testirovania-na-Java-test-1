import java.util.List;
import java.util.ArrayList;
public class LibraryRegistryImpl implements LibraryRegistry {
    private List<AbstractItem> items = new ArrayList<>();

    @Override
    public void add(AbstractItem item) {
        items.add(item);
    }

    @Override
    public AbstractItem findByInventoryNumber(String inventoryNumber) {
        // Реализация поиска по инвентарному номеру
        for (AbstractItem item : items) {
            if (item.getInventoryNumber().equals(inventoryNumber)) {
                return item;
            }
        }
        return null; // Объект не найден
    }

    @Override
    public List<AbstractItem> findByAuthor(String author) {
        // Реализация поиска по автору
        List<AbstractItem> foundItems = new ArrayList<>();
        for (AbstractItem item : items) {
            if (item.getAuthor().equals(author)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}