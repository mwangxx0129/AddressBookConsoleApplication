import java.io.IOException;

public class AddressBookApplication {
    private AddressBook addressBook;
    private Menu menu;

    public static void main(String args[]) throws IOException {
        Menu m = new Menu();
        m.run();
    }
}
