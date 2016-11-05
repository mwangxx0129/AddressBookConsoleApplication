import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AddressBook {

    private ArrayList<AddressEntry> addressEntryList;

    public ArrayList<AddressEntry> getAddressEntryList() {
        return addressEntryList;
    }

    /**
     * new a object of ArrayList
     */
    AddressBook() {
        addressEntryList = new ArrayList<>();
    }

    /**
     * list alphabetic order (sorted)
     */
    public void list() {
        Collections.sort(addressEntryList, AddressEntry.LastNameComparator);
    }

    /**
     * add object to addressEntryList, object is not null
     *
     * @param object of AddressEntry
     */
    public void add(AddressEntry object) {
        addressEntryList.add(object);
    }

    /**
     * remove addressEntry of lastName from addressEntryList
     *
     * @param lastName
     */
    public void remove(String lastName, int i) {
        ArrayList<AddressEntry> matchedList = find(lastName);
        addressEntryList.remove(matchedList.get(i));
    }

    /**
     * find a list contains string which start with certain string
     *
     * @param startOfLastName
     * @return a object of AddressEntry
     */
    public ArrayList<AddressEntry> find(String startOfLastName) {
        ArrayList<AddressEntry> matchedList = new ArrayList<>();
        for (AddressEntry tmp : addressEntryList) {
            // use regular expressions to match prefix "(?i)prefix.*"
            // use (?i) to enable case-insensitivity
            boolean isMatched = tmp.getLastName().matches("(?i)" + startOfLastName + ".*");
            if (isMatched) {
                matchedList.add(tmp);
            }
        }

        return matchedList;
    }

    /**
     * load records of "AddressEntry" from "file" to "addressEntryList"
     *
     * @param fileName
     * @throws IOException
     */
    public void readFromFile(String fileName) throws IOException {
        FileInputStream in = null;
        try {
            in = new FileInputStream(fileName);
            //Construct BufferedReader from InputStreamReader
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line = null;
            while ((line = br.readLine()) != null) {
                AddressEntry ae = null;
                if ((ae = extractAddressEntryFromString(line)) != null) {
                    add(ae);
                }
            }
            br.close();
        } finally {
            if (in != null) {
                in.close();
            }
        }
    }

    /**
     * extract AddressEntry from String
     *
     * @param line
     * @return object of AddressEntry, if string is valid, or return null.
     */
    private AddressEntry extractAddressEntryFromString(String line) {

        String[] field = line.split("[,\\s]+");
        // for illegal line
        if (field.length != 8) return null;

        AddressEntry ae =
                new AddressEntry(field[0], field[1], field[2], field[3], field[4], Integer.parseInt(field[5]), field[6], field[7]);
        return ae;
    }

    public void show() {

        for (AddressEntry entry : addressEntryList) {
            System.out.println(entry.toString());
        }
    }
}
