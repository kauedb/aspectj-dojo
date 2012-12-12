package dojo.aspect;

import java.lang.reflect.Field;

import dojo.annotation.Service;

import org.aspectj.lang.reflect.FieldSignature;

public aspect ServiceAspect {

	pointcut services(): get(@Service * *.*);
	
	Object around(): services(){
		Field field = ((FieldSignature)thisJoinPoint.getSignature()).getField();
		Object service = proceed();
		if(service == null){
			try{
				service = field.getType().newInstance();	
			}catch(Exception ex){
				ex.printStackTrace();
			}
			
		}
		// System.out.println(service + " @Service " + thisJoinPoint.getSignature());
		return service;
	}
	
}
