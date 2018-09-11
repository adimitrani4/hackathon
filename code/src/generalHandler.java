import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class generalHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String rootDir = "C:\\Users\\adi\\IdeaProjects\\Hackathon\\code\\src\\www\\";
		httpExchange.sendResponseHeaders(200, 0);
		OutputStream os = httpExchange.getResponseBody();
		String uriPath = httpExchange.getRequestURI().getPath();
		File htmlFile = new File(rootDir + uriPath);

		Headers headers = httpExchange.getResponseHeaders();
		headers.set("Content-Type", "text/html");
		FileInputStream fs = new FileInputStream(htmlFile);
		final byte[] buffer = new byte[0x10000];
		int count;
		while ((count = fs.read(buffer)) >= 0) {
			os.write(buffer, 0, count);
		}
		fs.close();
		os.close();
	}
}
