package dojo.service;

import java.util.List;

import dojo.dao.NewsDAO;
import dojo.domain.News;

public class NewsService implements Service{

	private NewsDAO newsDAO;
	
	public List<News> getNews(){
		newsDAO = new NewsDAO();
		return newsDAO.getAll();
	}
	
}
