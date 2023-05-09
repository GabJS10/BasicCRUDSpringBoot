package Gabriel.MiCRUDTV;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Gabriel.MiCRUDTV.Entity.Contacto;
import Gabriel.MiCRUDTV.Repository.ContactRepository;

@SpringBootApplication
public class MiCrudtvApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(MiCrudtvApplication.class, args);
	}



}
