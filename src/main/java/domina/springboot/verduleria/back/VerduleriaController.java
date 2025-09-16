package domina.springboot.verduleria.back;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verduras")
public class VerduleriaController {
	
	private final VerduleriaRepository verduleriaRepository;
	
	private VerduleriaController(VerduleriaRepository verduleriaRepository) {
		this.verduleriaRepository = verduleriaRepository;
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<Verdura> findById(@PathVariable Long id) {
		Optional<Verdura> verduraOptional = verduleriaRepository.findById(id);
		if (verduraOptional.isPresent()) {
			return ResponseEntity.ok(verduraOptional.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	private ResponseEntity<Iterable<Verdura>> findAll() {
		return ResponseEntity.ok(verduleriaRepository.findAll());
	}
}