import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class AddressEntryTest {
    @Test
    public void test() {
        ArrayList<AddressEntry> list = new ArrayList<>();
        AddressEntry ae = new AddressEntry("X", "Wa", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567");
        AddressEntry ae1 = new AddressEntry("Y", "A", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567");
        AddressEntry ae2 = new AddressEntry("Z", "B", "8888", "Hayward", "CA", 94000, "gamil.com", "5101234567");
        list.add(ae);
        list.add(ae1);
        list.add(ae2);

        Collections.sort(list, AddressEntry.LastNameComparator);

        for (AddressEntry tmp : list) {
            System.out.println(tmp.toString());
        }
    }
}