package Gabriel.MiCRUDTV.DAO;

import java.util.List;

import Gabriel.MiCRUDTV.Entity.Contacto;

public interface ContactDAO {
	List<Contacto> allContacts();
	void addOrEditContact(Contacto contacto);
	void deleteContact(Long id);
	Contacto getContact(Long id);
}
