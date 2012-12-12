package dojo.aspect;

import dojo.business.BusinessException;

public aspect BusinessExceptionAspect {
	
	before(Exception e): handler(Exception) && args(e){
		e.printStackTrace();
	}
	
	after() throwing(BusinessException ex): execution(* *.*(..)){
		System.out.println(thisJoinPoint.getSignature());
		System.out.println(ex.getMessage());
	}
	
}
