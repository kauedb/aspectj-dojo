package dojo.test;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dojo.domain.News;
import dojo.domain.Person;
import dojo.web.Dispatcher;
import dojo.web.FrontControl;
import dojo.web.HttpRequest;
import dojo.web.HttpResponse;

public class FrontControlTest {

	FrontControl frontControl;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		frontControl = new FrontControl();
	}

	@Test
	public void testHome() {
		HttpRequest request = new HttpRequest() {
			
			private Map<String, Object> attributes = new HashMap<String, Object>();
			
			@Override
			public void setAttribute(String name, Object value) {
				attributes.put(name, value);
			}
			
			@Override
			public String getRequestURL() {
				return "/home";
			}
			
			@Override
			public Object getAttribute(String value) {
				return attributes.get(value);
			}
			
			@Override
			public Dispatcher dispatch(String result) {
				return new Dispatcher(result);
			}
		};
		HttpResponse response = new HttpResponse() {};
		
		String result = frontControl.execute(request, response);
		assertEquals(result, "/Home.vm", result);
	}

	@Test
	public void testSignup_smokeTest() {
		HttpRequest request = new HttpRequest() {
			
			private Map<String, Object> attributes = new HashMap<String, Object>();
			
			@Override
			public void setAttribute(String name, Object value) {
				attributes.put(name, value);
			}
			
			@Override
			public String getRequestURL() {
				return "/signup";
			}
			
			@Override
			public Object getAttribute(String value) {
				return attributes.get(value);
			}
			
			@Override
			public Dispatcher dispatch(String result) {
				return new Dispatcher(result);
			}
		};
		
		Person rightPerson = new Person();
		rightPerson.setName("Good Jonny Test");
		rightPerson.setAge((byte)18);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, - rightPerson.getAge());
		rightPerson.setBirthDate(cal.getTime());
		rightPerson.setFavoriteColor("gree");
		//System.out.println(rightPerson);
		request.setAttribute("person", rightPerson);
		HttpResponse response = new HttpResponse() {};
		
		assertEquals("/Signup.vm", frontControl.execute(request, response));
	}
	
	@Test
	public void testDomainToString(){
		News news = new News();
		news.setPosted(new Date());
		news.setTitle("Some Title");
		news.setBody("Some news!!!");
		// System.out.println(news);
	}
	
	@Test
	public void testSignup_badColor() {
		HttpRequest request = new HttpRequest() {
			
			private Map<String, Object> attributes = new HashMap<String, Object>();
			
			@Override
			public void setAttribute(String name, Object value) {
				attributes.put(name, value);
			}
			
			@Override
			public String getRequestURL() {
				return "/signup";
			}
			
			@Override
			public Object getAttribute(String value) {
				return attributes.get(value);
			}
			
			@Override
			public Dispatcher dispatch(String result) {
				return new Dispatcher(result);
			}
		};
		
		Person rightPerson = new Person();
		rightPerson.setName("Bad Jonny Test");
		rightPerson.setAge((byte)18);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, - rightPerson.getAge());
		rightPerson.setBirthDate(cal.getTime());
		rightPerson.setFavoriteColor("blue");
		// System.out.println(rightPerson);
		request.setAttribute("person", rightPerson);
		HttpResponse response = new HttpResponse() {};
		
		assertEquals("/GlobalError.vm", frontControl.execute(request, response));
	}
	
	
}
