package IPINoteGods.IPINotes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class SampleController {

	@RequestMapping("test")
	@ResponseBody
	public String testPage() {
		return "test page";
	}
	
}