package webService.thrift.shared;

import org.apache.thrift.TException;

import webService.soap.handbook.handlerList.HandlerList;
import webService.soap.handbook.model.DefenitionModel;

public class SharedHandler implements SharedService.Iface {
	private HandlerList handlerList;

	public SharedHandler() {
		handlerList = new HandlerList();
	}

	@Override
	public String getDefenition(String name) throws TException {
		DefenitionModel searchingDefenition = handlerList.searchDefenition(name);
		if (searchingDefenition != null) {
			String response = searchingDefenition.getNameDefenition() + " - " + searchingDefenition.getBodyDefenition();
			return response;
		}
		String nullString = "не найдено";
		return nullString;
	}

	@Override
	public void addDefenition(String name, String body) throws TException {
		DefenitionModel inputDefenition = new DefenitionModel(name, body);
		handlerList.addDefenition(inputDefenition);
	}

	@Override
	public void updateDefenition(String name, String body) throws TException {
		DefenitionModel inputDefenition = new DefenitionModel(name, body);
		handlerList.updateDefenition(inputDefenition);
	}

	@Override
	public void deleteDefenition(String name) throws TException {
		handlerList.deleteDefenition(name);
	}

}
