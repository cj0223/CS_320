package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ContactService.Contact;
import ContactService.ContactService;

/**
 * JUnit test suite for the ContactService class.
 *
 * This class verifies that the ContactService meets all required specifications:
 * - Contacts can be added when their IDs are unique
 * - Duplicate contact IDs are rejected with IllegalArgumentException
 * - Contacts can be deleted by ID
 * - Updatable fields (firstName, lastName, phone, address) update correctly
 * - Contacts can be retrieved by ID
 */
public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(c);
        assertEquals(c, service.getContact("1"));
    }

    @Test
    public void testAddDuplicateContact() {
        ContactService service = new ContactService();
        Contact c1 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        Contact c2 = new Contact("1", "Jane", "Smith", "0987654321", "456 Elm St");

        service.addContact(c1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c2));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(c);
        service.deleteContact("1");

        assertNull(service.getContact("1"));
    }

    @Test
    public void testUpdateFields() {
        ContactService service = new ContactService();
        Contact c = new Contact("1", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(c);

        service.updateFirstName("1", "Jane");
        assertEquals("Jane", service.getContact("1").getFirstName());

        service.updateLastName("1", "Smith");
        assertEquals("Smith", service.getContact("1").getLastName());

        service.updatePhone("1", "0987654321");
        assertEquals("0987654321", service.getContact("1").getPhone());

        service.updateAddress("1", "456 Elm St");
        assertEquals("456 Elm St", service.getContact("1").getAddress());
    }
}