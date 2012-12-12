package dojo.aspect;

public aspect GoodPracticesAspect {

	declare warning: handler(Throwable) : "É uma boa prática especializar o exception.";
	
}