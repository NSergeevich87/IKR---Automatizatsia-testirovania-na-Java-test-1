class Book extends AbstractItem {
    private String title;

    public Book(String inventoryNumber, String author, String title) {
        super(inventoryNumber, author);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}