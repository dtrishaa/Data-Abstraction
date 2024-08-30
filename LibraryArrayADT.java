package librarymanagementSystem;

import java.util.Arrays;

public class LibraryArrayADT implements LibraryManagementSystem {
    private String[] referenceNumbers;
    private String[] books;
    private int size;

    public LibraryArrayADT() {
        referenceNumbers = new String[10]; 
        books = new String[10]; 
        size = 0;
    }

    @Override
    public void addBook(String referenceNumber, String bookName) {
        ensureCapacity();
        referenceNumbers[size] = referenceNumber;
        books[size] = bookName;
        size++;
    }

    @Override
    public void insertBook(int index, String referenceNumber, String bookName) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        ensureCapacity();
        for (int i = size; i > index; i--) {
            referenceNumbers[i] = referenceNumbers[i - 1];
            books[i] = books[i - 1];
        }
        referenceNumbers[index] = referenceNumber;
        books[index] = bookName;
        size++;
    }

    @Override
    public String getReferenceNumber(int index) {
        if (index < 0 || index >= size) {
            return "Invalid index";
        }
        return referenceNumbers[index];
    }

    @Override
    public int getTotalBooks() {
        return size;
    }

    private void ensureCapacity() {
        if (size == books.length) {
            books = Arrays.copyOf(books, books.length * 2); 
            referenceNumbers = Arrays.copyOf(referenceNumbers, referenceNumbers.length * 2); 
        }
    }

    
    @Override
    public String getBook(int index) {
        if (index < 0 || index >= size) {
            return "Invalid index";
        }
        return books[index];
    }
    public void removeBook(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid index");
            return;
        }
        for (int i = position; i < size - 1; i++) {
            referenceNumbers[i] = referenceNumbers[i + 1];
            books[i] = books[i + 1];
        }
        size--;
    }
}

