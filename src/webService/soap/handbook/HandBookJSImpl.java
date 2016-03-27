package webService.soap.handbook;

import javax.jws.WebService;

import webService.soap.handbook.handlerList.HandlerList;
import webService.soap.handbook.model.DefenitionModel;

//реализации отвечает именно этот веб-сервис
@WebService(endpointInterface = "webService.soap.handbook.HandBookJS")
public class HandBookJSImpl implements HandBookJS {
	private HandlerList handlerList;

	public HandBookJSImpl() {
		handlerList = new HandlerList();
	}

	@Override
	public DefenitionModel searchDefenition(String inputName) {
		DefenitionModel searchingDefenition = handlerList.searchDefenition(inputName);
		if (searchingDefenition != null) {
			return searchingDefenition;
		}
		return null;
	}

	@Override
	public void addDefenition(DefenitionModel inputDefenition) {
		System.out.println(inputDefenition);
		handlerList.addDefenition(inputDefenition);
	}

	@Override
	public void deleteDefenition(String inputName) {
		System.out.println(inputName);
		handlerList.deleteDefenition(inputName);
	}

	@Override
	public void updateDefenition(DefenitionModel inputDefenition) {
		System.out.println(inputDefenition);
		handlerList.updateDefenition(inputDefenition);
	}

}
