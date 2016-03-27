package webService.soap.handbook.handlerList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import webService.soap.handbook.DAO.SAXReader;
import webService.soap.handbook.model.DefenitionModel;

public class HandlerList {
	private List<DefenitionModel> defenitionList;

	public HandlerList() {
		defenitionList = new ArrayList<DefenitionModel>();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		SAXReader reader = null;
		try {
			parser = factory.newSAXParser();
			reader = new SAXReader();
			parser.parse("defenitions.xml", reader);
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		} catch (SAXException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		defenitionList = reader.getDefenitionsList();

	}

	public DefenitionModel searchDefenition(String inputName) {
		DefenitionModel inputDefenition = new DefenitionModel();
		inputDefenition.setNameDefenition(inputName);
		for (DefenitionModel searchingDefenition : defenitionList) {
			if (inputDefenition.getNameDefenition().equals(searchingDefenition.getNameDefenition())) {
				inputDefenition.setBodyDefenition(searchingDefenition.getBodyDefenition());
				return inputDefenition;
			}
		}
		return null;
	}

	public void deleteDefenition(String inputName) {
		if (inputName == null) {
			return;
		}
		DefenitionModel inputDefenition = new DefenitionModel();
		inputDefenition.setNameDefenition(inputName);
		for (DefenitionModel searchingDefenition : defenitionList) {
			if (inputDefenition.getNameDefenition().equals(searchingDefenition.getNameDefenition())) {
				inputDefenition = searchingDefenition;
				break;
			}
		}
		
		defenitionList.remove(inputDefenition);

	}

	public void addDefenition(DefenitionModel inputDefenition) {
		defenitionList.add(inputDefenition);
	}

	public void updateDefenition(DefenitionModel inputDefenition) {
		for (DefenitionModel searchingDefenition : defenitionList) {
			if (inputDefenition.getNameDefenition().equals(searchingDefenition.getNameDefenition())) {
				defenitionList.remove(searchingDefenition);
				defenitionList.add(inputDefenition);
			}
		}
	}

}
