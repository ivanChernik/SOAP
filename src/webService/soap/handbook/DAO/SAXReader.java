package webService.soap.handbook.DAO;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import webService.soap.handbook.model.DefenitionModel;


public class SAXReader extends DefaultHandler{
	private DefenitionModel defenition;
	private List<DefenitionModel> defenitionsList;
	private StringBuilder text;

	public SAXReader() {
		defenitionsList = new ArrayList<DefenitionModel>();
	}

	public List<DefenitionModel> getDefenitionsList() {
		return defenitionsList;
	}

	@Override
	public void startDocument() throws SAXException {
	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
		if (qName.equals("defenition")) {
			defenition = new DefenitionModel();
		}
		text = new StringBuilder();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		text.append(ch, start, length);
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

		if (qName.equals("name")) {
			defenition.setNameDefenition(text.toString());
		}
		if (qName.equals("body")) {
			defenition.setBodyDefenition(text.toString());
		}
		if (qName.equals("defenition")) {
			defenitionsList.add(defenition);
		}

	}

	@Override
	public void endDocument() {
	}

}
