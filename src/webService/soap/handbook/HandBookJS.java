package webService.soap.handbook;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import webService.soap.handbook.model.DefenitionModel;
//скелет веб-сервиса
@WebService
//стиль веб-сервиса и как он отображается в wsdl 
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface HandBookJS {
	//perationName — отвечает за имя операции
	//action — этот атрибут отвечает за значения поля soapAction (стандартным значением этого атрибута является пустая строка) 
	//exclude — определяет должен ли метод отображаться в wsdl файле или нет.
	@WebMethod
	public DefenitionModel searchDefenition(String inputName);
	
	@WebMethod
	public void addDefenition(DefenitionModel inputDefenition);
	
	@WebMethod
	public void deleteDefenition(String inputName);
	
	@WebMethod
	public void updateDefenition(DefenitionModel inputDefenition);
	

}
