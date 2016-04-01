package webService.soap.handbook.endpoint;


import org.apache.thrift.server.TServer.Args;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;

import webService.thrift.shared.SharedHandler;
import webService.thrift.shared.SharedService;

public class HandBookWSPublisher {
	public static SharedHandler handler;

	public static SharedService.Processor processor;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Endpoint.publish("http://localhost:9999/handbook", new
		// HandBookJSImpl());
		// System.out.println("Server");
		try {
			handler = new SharedHandler();
			processor = new SharedService.Processor(handler);

			Runnable simple = new Runnable() {
				public void run() {
					simple(processor);
				}
			};

			new Thread(simple).start();
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public static void simple(SharedService.Processor processor) {
		try {
			TServerTransport serverTransport = new TServerSocket(9090);
			TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));

			System.out.println("Starting the simple server...");
			server.serve();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
