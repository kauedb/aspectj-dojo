package dojo.web.action;

import dojo.domain.Person;
import dojo.service.ServiceFactory;
import dojo.service.SignupService;
import dojo.web.HttpRequest;
import dojo.web.HttpResponse;

public class SignupAction implements Action {

	private SignupService signupService;
	
	@Override
	public String execute(HttpRequest request, HttpResponse response) throws Exception {
		
		signupService = (SignupService)ServiceFactory.getInstance().getService("Signup");
		
		Person person = (Person) request.getAttribute("person");
		
		signupService.execute(person);
		
		return "/Signup.vm";
	}

}
