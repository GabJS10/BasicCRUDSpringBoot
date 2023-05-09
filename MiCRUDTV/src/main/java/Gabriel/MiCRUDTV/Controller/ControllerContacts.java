package Gabriel.MiCRUDTV.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Gabriel.MiCRUDTV.DAO.ContactDAO;
import Gabriel.MiCRUDTV.Entity.Contacto;
import jakarta.validation.Valid;

@Controller
public class ControllerContacts {

	@Autowired
	private ContactDAO DAO;

	@GetMapping("/")
	public String paginaInicio() {
		return "index";
	}

	@GetMapping("/allContacts")
	public String listaContactos(Model modelo) {

		modelo.addAttribute("listContacts", DAO.allContacts());

		return "ListContacts";
	}

	@GetMapping("/addContact")
	public String pageAddContact(Model modelo) {

		modelo.addAttribute("contact", new Contacto());

		return "add";
	}

	@PostMapping("/addOrUpdate")
	public String addOrUpdate(@Valid @ModelAttribute("contact") Contacto contact, BindingResult validacion,
			RedirectAttributes redirect) {

		if (validacion.hasErrors()) {
			if (contact.getId() != null) {
				return "updatePage";
			}
			return "add";
		}

		redirect.addFlashAttribute("msg", "Operacion completada con exito");
		DAO.addOrEditContact(contact);
		return "redirect:/allContacts";
	}

	@GetMapping("/delete/{id}")
	public String deleteContact(@PathVariable Long id, RedirectAttributes redirect) {

		DAO.deleteContact(id);
		redirect.addFlashAttribute("msg", "Registro eliminado con exito");
		return "redirect:/allContacts";

	}

	@GetMapping("/update/{id}")
	public String pageUpdate(@PathVariable Long id, Model modelo) {

		modelo.addAttribute("contact", DAO.getContact(id));

		return "updatePage";
	}

}
