package dojo.aspect;


public aspect LogAspect {

	
	private Integer count = 0;
	
	
	public void count(){
		count++;
	}
	
	pointcut allServices(): within(dojo.service.*) && call(* *.*(..)); // execution(String Person.setName(String))
	
	
	before() : allServices(){
		count();
		System.out.println("Aqui é antes.");
	}
	
	/*
	after() : allServices(){
		
	}*/
	
	Object around() : allServices() {
		System.out.println(thisJoinPoint.getSignature() + count.toString());
		return proceed();
	}
	
	
	Object around() : within(dojo.service.*) && call(* *.append(..)) {
		count();
		System.out.println(thisJoinPoint.getSignature() + count.toString());
		return proceed();
	}
	
}
