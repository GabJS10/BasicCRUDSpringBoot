package Gabriel.MiCRUDTV.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Gabriel.MiCRUDTV.Entity.Contacto;

@Repository
public interface ContactRepository extends JpaRepository<Contacto, Long> {

}
