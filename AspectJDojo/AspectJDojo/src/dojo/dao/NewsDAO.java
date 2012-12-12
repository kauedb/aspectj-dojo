package dojo.dao;

import java.util.ArrayList;
import java.util.List;

import dojo.domain.News;
import dojo.util.DojoUtil;

public class NewsDAO {

	private static List<News> news = new ArrayList<News>();
	{
		news.add(new News());
		news.add(new News());
		news.add(new News());
	}
	
	
	public List<News> getAll(){
		DojoUtil.simulateProcessing();
		return news;
	}
	
}
