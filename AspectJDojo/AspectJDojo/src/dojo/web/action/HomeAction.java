package dojo.web.action;

import dojo.annotation.Service;
import dojo.service.NewsService;
import dojo.service.ServiceFactory;
import dojo.web.HttpRequest;
import dojo.web.HttpResponse;

public class HomeAction implements Action{
	
	//@Service
	private NewsService newsService;
	
	public String execute(HttpRequest request, HttpResponse response){
		
		newsService = (NewsService) ServiceFactory.getInstance().getService("News");
		
		request.setAttribute("news", newsService.getNews());
		
		return "/Home.vm";
	}
	
}
