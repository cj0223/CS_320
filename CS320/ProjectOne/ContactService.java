package ContactService;

import java.util.HashMap;
import java.util.Map;

/**
 * The ContactService class manages Contact objects in memory.
 * It supports adding, updating, retrieving, and deleting contacts
 * using a HashMap keyed by contact ID.
 *
 * Requirements:
 * - Add contacts with unique IDs
 * - Delete contacts by ID
 * - Update firstName, lastName, phone, and address fields
 */
public class ContactService {

    // In-memory storage for contacts
    private Map<String, Contact> contacts = new HashMap<>();

    /**
     * Adds a new contact to the service.
     *
     * @param contact the Contact object to add
     * @throws IllegalArgumentException if a contact with the same ID already exists
     */
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Duplicate contact ID");
        }
        contacts.put(contact.getContactId(), contact);
    }

    /**
     * Deletes a contact by its ID.
     *
     * @param contactId the ID of the contact to delete
     */
    public void deleteContact(String contactId) {
        contacts.remove(contactId);
    }

    /**
     * Updates the first name of a contact.
     *
     * @param contactId the ID of the contact to update
     * @param firstName the new first name
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setFirstName(firstName);
        }
    }

    /**
     * Updates the last name of a contact.
     *
     * @param contactId the ID of the contact to update
     * @param lastName the new last name
     */
    public void updateLastName(String contactId, String lastName) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setLastName(lastName);
        }
    }

    /**
     * Updates the phone number of a contact.
     *
     * @param contactId the ID of the contact to update
     * @param phone the new phone number
     */
    public void updatePhone(String contactId, String phone) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setPhone(phone);
        }
    }

    /**
     * Updates the address of a contact.
     *
     * @param contactId the ID of the contact to update
     * @param address the new address
     */
    public void updateAddress(String contactId, String address) {
        Contact c = contacts.get(contactId);
        if (c != null) {
            c.setAddress(address);
        }
    }

    /**
     * Retrieves a contact by its ID.
     *
     * @param contactId the ID of the contact to retrieve
     * @return the Contact object, or null if not found
     */
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
