package dojo.aspect;

import dojo.domain.Person;

import dojo.domain.News;

privileged aspect DomainAspect {
	
	interface Domain {}
	
	declare parents: dojo.domain.* implements Domain;
	
	public int Domain.lastName = 0;
	
	public String Domain.toString(){
		return this.getClass().getSimpleName();
	}
	
	public String Person.toString(){
		return this.name;
	}
	
	public Person.new(String param){
		super();
	}
	
	
}