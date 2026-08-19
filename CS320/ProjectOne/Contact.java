package ContactService;

/**
 * The Contact class represents a single contact record in the system.
 * Each contact contains a unique, non-updatable ID along with personal
 * information fields that must meet specific length and format requirements.
 *
 * Required fields:
 * - contactId: unique, non-null, max length 10, not updatable
 * - firstName: non-null, max length 10
 * - lastName: non-null, max length 10
 * - phone: non-null, exactly 10 digits
 * - address: non-null, max length 30
 */
public class Contact {

    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Creates a new Contact object with validated fields.
     *
     * @param contactId the unique ID for the contact (max 10 characters, not null)
     * @param firstName the first name (max 10 characters, not null)
     * @param lastName the last name (max 10 characters, not null)
     * @param phone the phone number (exactly 10 digits, not null)
     * @param address the contact address (max 30 characters, not null)
     * @throws IllegalArgumentException if any field violates its constraints
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {

        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Invalid contact ID");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    /** @return the unique contact ID (not updatable) */
    public String getContactId() {
        return contactId;
    }

    /** @return the first name */
    public String getFirstName() {
        return firstName;
    }

    /** @return the last name */
    public String getLastName() {
        return lastName;
    }

    /** @return the phone number */
    public String getPhone() {
        return phone;
    }

    /** @return the address */
    public String getAddress() {
        return address;
    }

    /**
     * Updates the first name.
     *
     * @param firstName new first name (max 10 characters, not null)
     * @throws IllegalArgumentException if invalid
     */
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid first name");
        }
        this.firstName = firstName;
    }

    /**
     * Updates the last name.
     *
     * @param lastName new last name (max 10 characters, not null)
     * @throws IllegalArgumentException if invalid
     */
    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid last name");
        }
        this.lastName = lastName;
    }

    /**
     * Updates the phone number.
     *
     * @param phone new phone number (exactly 10 digits, not null)
     * @throws IllegalArgumentException if invalid
     */
    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phone = phone;
    }

    /**
     * Updates the address.
     *
     * @param address new address (max 30 characters, not null)
     * @throws IllegalArgumentException if invalid
     */
    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }
}
