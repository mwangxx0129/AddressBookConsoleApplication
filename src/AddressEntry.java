
import java.util.Comparator;

public class AddressEntry {
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;
    private String phone;

    public AddressEntry() {

    }

    /**
     * Constructor with parameters
     *
     * @param firstName
     * @param lastName
     * @param street
     * @param city
     * @param state
     * @param zip
     * @param email
     * @param phone
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, int zip, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phone = phone;
    }

    /**
     * get string of all members of variable
     *
     * @return
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " \n"
                + street + " \n"
                + city + " " + state + " " + zip + " \n"
                + email + " \n"
                + phone + " \n";
    }

    /**
     * Comparator for sorting the list by lastName
     */
    public static Comparator<AddressEntry> LastNameComparator
            = new Comparator<AddressEntry>() {

        public int compare(AddressEntry ae1, AddressEntry ae2) {

            String lastName1 = ae1.getLastName().toUpperCase();
            String lastName2 = ae2.getLastName().toUpperCase();

            //ascending order
            return lastName1.compareTo(lastName2);

            //descending order
            //return lastName2.compareTo(lastName1);
        }
    };

}
