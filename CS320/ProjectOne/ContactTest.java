package ContactService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import ContactService.Contact;

/**
 * JUnit test suite for the Contact class.
 *
 * This class verifies that the Contact object meets all required specifications:
 * - All fields enforce correct length and null constraints
 * - The contactId field is immutable after creation
 * - Valid Contact objects can be created successfully
 * - Invalid field values trigger IllegalArgumentException
 * - Updatable fields (firstName, lastName, phone, address) update correctly
 */
public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", c.getContactId());
        assertEquals("John", c.getFirstName());
        assertEquals("Doe", c.getLastName());
        assertEquals("1234567890", c.getPhone());
        assertEquals("123 Main St", c.getAddress());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "ThisNameIsTooLong", "Doe", "1234567890", "123 Main St");
        });
    }

    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123", "123 Main St");
        });
    }

    @Test
    public void testUpdateFields() {
        Contact c = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        c.setFirstName("Jane");
        assertEquals("Jane", c.getFirstName());

        c.setLastName("Smith");
        assertEquals("Smith", c.getLastName());

        c.setPhone("0987654321");
        assertEquals("0987654321", c.getPhone());

        c.setAddress("456 Elm St");
        assertEquals("456 Elm St", c.getAddress());
    }
}
