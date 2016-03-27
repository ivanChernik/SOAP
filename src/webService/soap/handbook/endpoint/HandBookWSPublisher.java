package webService.soap.handbook.endpoint;

import javax.xml.ws.Endpoint;
import webService.soap.handbook.HandBookJSImpl;
import webService.soap.handbook.handlerList.HandlerList;

public class HandBookWSPublisher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:9999/handbook", new HandBookJSImpl());
		System.out.println("Server");
	}

}
