package dojo.web.action;

import dojo.web.HttpRequest;
import dojo.web.HttpResponse;

public interface Action {

	public String execute(HttpRequest request, HttpResponse response) throws Exception;
	
}
