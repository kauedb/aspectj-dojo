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
	 * O nome do serviço invocado deve começar com letra maiuscula.
	 * Por exemplo: 
	 * 	Correto => Carro
	 * 	Errado => carro
	 * Se o serviço não for encontrado será devolvida uma referencia nula.
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
