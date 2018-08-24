import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class JavaHttpServer {

	public static void main(String args[]){
		int port = 8080;
		try {
			HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
			System.out.println("server started at " + port);
			//server.createContext("/", new RootHandler());
			server.createContext("/", new generalHandler());
			//server.createContext("/echoHeader", new EchoHeaderHandler());
			//server.createContext("/echoGet", new EchoGetHandler());
			//server.createContext("/echoPost", new EchoPostHandler());
			server.setExecutor(null);
			server.start();
		}
		catch (IOException e){

		}
	}
}
