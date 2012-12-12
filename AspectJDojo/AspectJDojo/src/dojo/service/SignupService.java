package dojo.service;

import dojo.business.BusinessException;
import dojo.business.SignupBusiness;
import dojo.domain.Person;
import dojo.util.DojoUtil;

public class SignupService implements Service{

	@dojo.annotation.Service
	private SignupBusiness business;
	
	public void execute(Person person) throws BusinessException {
		if(business.canSignin(person)){
			DojoUtil.simulateProcessing();
		}else{
			throw new BusinessException("Cor invalida");
		}
	}

}
