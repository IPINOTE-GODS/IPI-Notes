package IPINoteGods.IPINotes;
import java.net.URISyntaxException;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class IpiNotesApplication {

	public static void main(String[] args) throws URISyntaxException {
		SpringApplication.run(IpiNotesApplication.class, args);	
		System.out.println("\n=== LAUNCH SUCCESS ===");
	}
	
}
