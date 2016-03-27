package webService.soap.handbook;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import webService.soap.handbook.model.DefenitionModel;
//������ ���-�������
@WebService
//����� ���-������� � ��� �� ������������ � wsdl 
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL)
public interface HandBookJS {
	//perationName � �������� �� ��� ��������
	//action � ���� ������� �������� �� �������� ���� soapAction (����������� ��������� ����� �������� �������� ������ ������) 
	//exclude � ���������� ������ �� ����� ������������ � wsdl ����� ��� ���.
	@WebMethod
	public DefenitionModel searchDefenition(String inputName);
	
	@WebMethod
	public void addDefenition(DefenitionModel inputDefenition);
	
	@WebMethod
	public void deleteDefenition(String inputName);
	
	@WebMethod
	public void updateDefenition(DefenitionModel inputDefenition);
	

}
