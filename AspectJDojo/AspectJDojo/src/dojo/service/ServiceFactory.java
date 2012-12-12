package dojo.service;

/***
 * Singleton
 */
public class ServiceFactory {

	private static ServiceFactory instance;
	
	private ServiceFactory(){
		super();
	}
	public static ServiceFactory getInstance(){
		if(instance == null){
			instance = new ServiceFactory();
		}
		
		return instance;
	}
	/***
	 * O nome do servi�o invocado deve come�ar com letra maiuscula.
	 * Por exemplo: 
	 * 	Correto => Carro
	 * 	Errado => carro
	 * Se o servi�o n�o for encontrado ser� devolvida uma referencia nula.
	 * */
	public Service getService(String name){
		Service result = null;
		try{
			result  = (Service) Class.forName("dojo.service." + name + "Service").newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
