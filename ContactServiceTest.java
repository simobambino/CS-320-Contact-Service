package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact contact;

    @BeforeEach
    void setUp() {
        service = new ContactService();
        contact = new Contact("001", "Alice", "Smith", "1234567890", "456 Oak St");
        service.addContact(contact);
    }

    @Test
    void testAddContact() {
        Contact newContact = new Contact("002", "Bob", "Jones", "0987654321", "789 Pine St");
        service.addContact(newContact);
        assertEquals("Bob", service.getContact("002").getFirstName());
    }

    @Test
    void testDeleteContact() {
        service.deleteContact("001");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("001"));
    }

    @Test
    void testUpdateFirstName() {
        service.updateFirstName("001", "Eva");
        assertEquals("Eva", service.getContact("001").getFirstName());
    }

    @Test
    void testUpdatePhoneInvalid() {
        assertThrows(IllegalArgumentException.class, () ->
                service.updatePhone("001", "bad"));
    }
}
