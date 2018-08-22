import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class LoginHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange)throws IOException {

		//httpExchange.sendResponseHeaders(200, response.length());
		OutputStream os = httpExchange.getResponseBody();
		File htmlFile = new File("index.html");
		httpExchange.sendResponseHeaders(200, Long.valueOf(htmlFile.length()).intValue());
		Path htmlPath = htmlFile.toPath();
		Files.copy(htmlPath, os);
		//os.flush();
		os.close();
	}
}
