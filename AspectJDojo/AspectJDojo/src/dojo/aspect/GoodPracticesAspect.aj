package dojo.aspect;

public aspect GoodPracticesAspect {

	declare warning: handler(Throwable) : "� uma boa pr�tica especializar o exception.";
	
}