package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDAODOMImpl implements INewsDAO { // 구현체

	List<News> list;
	Document doc;

	@Override
	public List<News> getNewsList(String url) { // main에서 호출되어지는 메서드
		list = new ArrayList<>();
		connectNews(url);
		NodeList itemlist = doc.getElementsByTagName("item");
		for (int i = 0; i < itemlist.getLength(); i++) {
			Node n = itemlist.item(i);
			NodeList childList = n.getChildNodes();

			// item의 개수만큼 News 객체를 생성
			News news = new News();

			for (int j = 0; j < childList.getLength(); j++) {
				if (childList.item(j).getNodeType() == Node.ELEMENT_NODE) { // 노드 구분(태그, 텍스트)
					String tagName = childList.item(j).getNodeName();
					if (tagName.equals("title")) { // 태그명 얻기 <title>
//						childList.item(j).getTextContent(); // title의 내용 : 제목
						news.setTitle(childList.item(j).getTextContent()); // title의 내용 : 제목
					} else if (tagName.equals("link")) {
						news.setLink(childList.item(j).getTextContent());
					} else if (tagName.equals("description")) {
						news.setDesc(childList.item(j).getTextContent());
						break; // 그 외에 필요없는 내용은 탐색할 필요 없음
					}
				}
			} // for
			
			list.add(news);
		}
		return list;
	}

	@Override
	public News search(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void connectNews(String url) {
		// 공장(factory) - 일꾼(Parser) - 파싱
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();

			// 파싱
			doc = builder.parse(url); // DOM Programming의 시작

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	} // connectNews
}
