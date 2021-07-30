package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO { // 구현체

	List<News> list;
	News news;
	String content;
	

	@Override
	public List<News> getNewsList(String url) {
		list = new ArrayList<>();
		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectNews(String url) {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
//			SAXHandler sh = new SAXHandler();
//			parser.parse(url, sh); // 이렇게 하면되는데 어차피 한번만 쓰니깐 this로
			parser.parse(url, new SAXHandler()); // this는 위치를 나타내는 것 
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////// <내부 클래스 시작>
	
	public class SAXHandler extends DefaultHandler  {
		StringBuilder b;
		boolean flag; // false
		News n;
		
		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			if(qName.equals("item")) { 
				news = new News();
				flag = true;
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if(qName.equals("item")) {
				list.add(news);
				news = null;
				flag = false;
			} else if (qName.equals("title")) {
				if(flag) news.setTitle(content);
			} else if (qName.equals("link")) {
				if(flag) news.setLink(content);
			} else if (qName.equals("description")) {
				if(flag) news.setDesc(content);
			}
			
		}// endElement
		
		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {
			content = new String(ch, start, length);
		}
	}

	
	///////////////////////////////////////////////////////// <내부 클래스 끝>
	
} // end class NewsDAOSAXImpl
