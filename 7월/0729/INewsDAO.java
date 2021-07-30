package com.ssafy.news;

import java.util.List;

public interface INewsDAO { // 명세
	
	/* public abstract*/List<News> getNewsList(String url);
	News search(int index);
		
}
