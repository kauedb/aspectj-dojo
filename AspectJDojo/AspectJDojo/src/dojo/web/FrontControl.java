package dojo.web;

import java.util.HashMap;
import java.util.Map;

import dojo.web.action.Action;
import dojo.web.action.HomeAction;
import dojo.web.action.SignupAction;

public class FrontControl {

	private static Map<String, String> navigationConfig = new HashMap<String, String>();
	static {
		navigationConfig.put("/home", HomeAction.class.getName());
		navigationConfig.put("/signup", SignupAction.class.getName());
	}
	
	
	public String execute(HttpRequest request, HttpResponse response) {
		String result = null;
		try {
			
			String url = request.getRequestURL();
			Action action = (Action)Class.forName(navigationConfig.get(url)).newInstance();
			
			synchronized (action) {
				result = action.execute(request, response);
			}
			
			if(result != null){
				request.dispatch(result).execute(request, response);
			}else{
				result = "/GlobalError.vm";
			}
			
		} catch (Throwable e) {
			result = "/GlobalError.vm";
		}
		request.dispatch(result).execute(request, response);
		
		return result;
	}
	
	
	
}
