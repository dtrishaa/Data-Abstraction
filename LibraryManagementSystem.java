package librarymanagementSystem;

import java.util.List;

public abstract interface LibraryManagementSystem {
	abstract   void addBook(String referenceNumber, String bookName);
	abstract   void insertBook(int index, String referenceNumber, String bookName);
	abstract  String getReferenceNumber(int index);
	abstract  String getBook(int index);
	abstract  int getTotalBooks();
	boolean removeElementAt(List<String> list, int index);
	abstract void removeBook(int position);
	
}
