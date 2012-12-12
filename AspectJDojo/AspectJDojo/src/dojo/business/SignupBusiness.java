package dojo.business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dojo.domain.Person;

public class SignupBusiness {

	public Boolean canSignin(Person person){
		if(person.getAge() < 18){
			return false;
		}
		
		if("blue".equals(person.getFavoriteColor())){
			return false;
		}
		
		if(person.getBirthDate().after(new Date())){
			return false;
		}
		
		try {
			if(person.getBirthDate().before(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1900"))){
				return false;
			}
		} catch (ParseException e) {
			return false;
		}
		
		return true;
		
	}
	
}
