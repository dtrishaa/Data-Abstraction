package librarymanagementSystem;

import java.util.Arrays;
import java.util.Stack;

public class LibraryArrayADT implements LibraryManagementSystem {
    private String[] referenceNumbers;
    private String[] books;
    private int size;
    private Stack<Books> bookStack;  

    public LibraryArrayADT() {
        referenceNumbers = new String[10];
        books = new String[10];
        size = 0;
        bookStack = new Stack<>();  
    }

    @Override
    public void addBook(String referenceNumber, String bookName) {
        ensureCapacity();
        referenceNumbers[size] = referenceNumber;
        books[size] = bookName;
        size++;
        Books newBook = new Books(referenceNumber, bookName);  
        bookStack.push(newBook);  
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
    public String getBook(int index) {
        if (index < 0 || index >= size) {
            return "Invalid index";
        }
        return books[index];
    }

    @Override
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
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Books popBook() {  
        if (!bookStack.isEmpty()) {
            Books removedBook = bookStack.pop();

          
            for (int i = 0; i < size; i++) {
                if (books[i].equals(removedBook.getName()) && referenceNumbers[i].equals(removedBook.getReferenceNumber())) {
                   
                    for (int j = i; j < size - 1; j++) {
                        books[j] = books[j + 1];
                        referenceNumbers[j] = referenceNumbers[j + 1];
                    }
                    
                    size--;
                    break;
                }
            }

            return removedBook;
        } else {
            System.out.println("Stack is empty, no book to pop.");
            return null;
        }
    }

    @Override
    public Books peekBook() {  
        if (!bookStack.isEmpty()) {
            return bookStack.peek();
        } else {
            System.out.println("Stack is empty, no book to peek.");
            return null;
        }
    }

    @Override
    public void clearBooks() {
        Arrays.fill(referenceNumbers, null);
        Arrays.fill(books, null);
        size = 0;
    }
}

