package ADT;

public class Library {
    private dynamicarray<String> books;

    public Library() {
        books = new dynamicarray<>();
    }

    public void addBook(String book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        books.remove(index);
    }

    public String getBook(int index) {
        return books.get(index);
    }

    public int getTotalBooks() {
        return books.size();
    }

    public boolean isLibraryEmpty() {
        return books.isEmpty();
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i));
            }
        }
    }
}

