import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private AddressBook book;
    private Scanner in;

    private String[] optionl = {
            "a) Loading From File",
            "b) Addition",
            "c) Removal",
            "d) Find",
            "e) Listing",
            "f) Quit",
    };

    Menu() {
        book = new AddressBook();
        in = new Scanner(System.in);
    }

    /**
     * display Menu Options
     */
    public void displayMenuOptions() {
        System.out.println("********************");
        System.out.println("Please enter in your menu selection");
        for (int i = 0; i < optionl.length; i++) {
            System.out.println(optionl[i]);
        }
        System.out.println("********************");
    }

    /**
     * run this application in console
     *
     * @throws IOException
     */
    public void run() throws IOException {
        char c = 'f'; // init c as 'f'
        do {
            displayMenuOptions();
            System.out.print(">");

            c = in.nextLine().charAt(0);
            System.out.println(c);
            switch (c) {
                case 'a':
                    load();
                    break;
                case 'b':
                    add();
                    break;
                case 'c':
                    remove();
                    break;
                case 'd':
                    find();
                    break;
                case 'e':
                    list();
                    break;
                default:
                    ;
                    break;
            }
        } while (c != 'f');

    }

    /**
     * load file to AddressBook
     *
     * @throws IOException
     */
    public void load() throws IOException {

        System.out.println("Enter in FileName: ");
        System.out.print(">");

        String filePath = in.nextLine();
        //System.out.println(filePath);
        book.readFromFile(filePath);
        book.show();
    }

    /**
     * add the input info of AddressEntry into AddressBook
     */
    public void add() {

        System.out.println("First Name:");
        System.out.print(">");
        String firstName = in.nextLine();

        System.out.println("Last Name:");
        System.out.print(">");
        String lastName = in.nextLine();

        System.out.println("Street:");
        System.out.print(">");
        String street = in.nextLine();

        System.out.println("City:");
        System.out.print(">");
        String city = in.nextLine();

        System.out.println("State:");
        System.out.print(">");
        String state = in.nextLine();

        System.out.println("Zip:");
        System.out.print(">");
        String zipString = in.nextLine();
        int zip = Integer.parseInt(zipString);

        System.out.println("Phone: xxx-aaa-bbbb");
        System.out.print(">");
        String phone = in.nextLine();

        System.out.println("Email:");
        System.out.print(">");
        String email = in.nextLine();

        AddressEntry ae = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
        System.out.println(ae.toString());
        book.add(ae);
    }

    /**
     * remove certain AddressEntry based on user's input lastName and selected index
     */
    public void remove() {

        System.out.println("Enter in Last Name of contact to remove:");
        System.out.print(">");
        String lastName = in.nextLine();
        ArrayList<AddressEntry> matchedList = new ArrayList<>();
        matchedList = book.find(lastName);
        showAddressEntryList(matchedList);

        int i = 0;
        System.out.print(">");
        System.out.println("select which one you need to remove");
        i = in.nextInt();

        System.out.println("Hit y to remove the following entry or n to return to main menu:");
        System.out.println(matchedList.get(i - 1).toString());
        System.out.print(">");


        String isTrue = in.nextLine();
        isTrue = in.nextLine(); // need fix

        if (isTrue.equals("y")) {
            book.remove(lastName, i - 1);
            System.out.println("You have successfully removed the " + matchedList.get(i - 1).getFirstName() + " " + matchedList.get(i - 1).getLastName() + " contact");
        }

    }

    /**
     * find list of AddressEntry which match start of user's input
     */
    public void find() {
        System.out.println("Enter in all or the begining of the Last Name of the contact you wish to find:");
        System.out.print(">");
        String lastName = in.nextLine();
        ArrayList<AddressEntry> matchedList = new ArrayList<>();
        matchedList = book.find(lastName);
        System.out.println("The following " + matchedList.size() + " entries were found in the address book for a last name starting with \"Grew\":");
        showAddressEntryList(matchedList);
    }

    /**
     * list AddressBook's AddressEntry
     */
    public void list() {
        book.list();
        book.show();
    }

    /**
     * show a ArrayList of AddressEntry
     *
     * @param list
     */
    private void showAddressEntryList(ArrayList<AddressEntry> list) {
        for (int i = 0; i < list.size(); i++) {
            AddressEntry ae = list.get(i);
            System.out.println((i + 1) + ":\n" + ae.toString());
        }
    }
}
