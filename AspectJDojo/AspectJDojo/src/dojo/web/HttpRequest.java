package dojo.web;

public interface HttpRequest {

	
	public String getRequestURL();

	public Dispatcher dispatch(String result);

	public void setAttribute(String name, Object value);

	public Object getAttribute(String name);
	
}
