package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertEquals("12345", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testSettersWorkCorrectly() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("0987654321");
        assertEquals("0987654321", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test
    void testInvalidPhoneThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    void testInvalidFirstNameThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", null, "Doe", "1234567890", "123 Main St"));
    }
}
