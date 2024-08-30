package librarymanagementSystem;

public abstract interface LibraryManagementSystem {
    void addBook(String referenceNumber, String bookName);
    void insertBook(int index, String referenceNumber, String bookName);
    String getReferenceNumber(int index);
    String getBook(int index);
    int getTotalBooks();
    void removeBook(int position);


    int size(); 
    boolean isEmpty();
}
