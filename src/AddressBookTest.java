import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

public class AddressBookTest {
    @Test
    public void find() throws IOException {
        AddressBook book = new AddressBook();
        book.readFromFile("input.txt");
        book.list();
        show(book);
        ArrayList<AddressEntry> matchedList = new ArrayList<>();
        matchedList = book.find("M");
        System.out.println(matchedList);
        book.remove("MA", 0);
        show(book);
    }

    public void load() throws IOException {
        AddressBook book = new AddressBook();
        book.readFromFile("input.txt");
        book.list();
        show(book);

    }

    public void add() throws Exception {
        AddressBook book = new AddressBook();
        book.add(new AddressEntry("X", "Wa", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567"));
        book.add(new AddressEntry("Y", "A", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567"));
        book.add(new AddressEntry("Z", "B", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567"));
        book.list();
        show(book);
    }

    public void show(AddressBook book) {
        ArrayList<AddressEntry> list = book.getAddressEntryList();
        for (AddressEntry entry : list) {
            System.out.println(entry.toString());
        }
    }

}