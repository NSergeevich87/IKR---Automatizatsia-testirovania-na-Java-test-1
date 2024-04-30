class Journal extends AbstractItem {
    private String journalName;

    public Journal(String inventoryNumber, String author, String journalName) {
        super(inventoryNumber, author);
        this.journalName = journalName;
    }

    public String getJournalName() {
        return journalName;
    }
}