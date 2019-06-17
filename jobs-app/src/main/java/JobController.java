import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JobController {
	
	@GetMapping(value ="/")
	public String rootView() {
		return "index"; // goes to index.html file, /src/main/resources/index.html
	}
}
