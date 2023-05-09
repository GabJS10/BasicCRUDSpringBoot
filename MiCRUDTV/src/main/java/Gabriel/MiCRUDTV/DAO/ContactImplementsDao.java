package Gabriel.MiCRUDTV.DAO;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Gabriel.MiCRUDTV.Entity.Contacto;
import Gabriel.MiCRUDTV.Repository.ContactRepository;


@Service
@Transactional
public class ContactImplementsDao implements ContactDAO {
	
	@Autowired
	private ContactRepository repo;
		
	@Override
	public List<Contacto> allContacts() {
		return repo.findAll();
	}

	@Override
	public void addOrEditContact(Contacto contacto) {
		contacto.setFechaRegistro(LocalDateTime.now());
		System.out.println(contacto);
		repo.save(contacto);
	}

	@Override
	public void deleteContact(Long id) {
		repo.deleteById(id);

	}

	@Override
	public Contacto getContact(Long id) {
		return repo.findById(id).get();
	}

}
