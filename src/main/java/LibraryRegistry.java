import java.util.List;
public interface LibraryRegistry {
    void add(AbstractItem item);
    AbstractItem findByInventoryNumber(String inventoryNumber);
    List<AbstractItem> findByAuthor(String author);
}