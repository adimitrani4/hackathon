import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

public class requestHandler implements HttpHandler {
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
        InputStreamReader isr =  new InputStreamReader(httpExchange.getRequestBody(),"utf-8");
        BufferedReader br = new BufferedReader(isr);
        System.out.println(br.read());

        int b;
        StringBuilder buf = new StringBuilder(512);
        while ((b = br.read()) != -1) {
            buf.append((char) b);
        }
        System.out.println(buf.toString());

        br.close();
        isr.close();




//        System.out.println(httpExchange.getRemoteAddress().toString());
//        System.out.println(is.read());
//        OutputStream os = httpExchange.getResponseBody();
//        System.out.println(response.getBytes());


        //------------- General response
		String response = "<h3>Welcome!</h3>";
        httpExchange.sendResponseHeaders(200, response.length());
        //-------------
        // TODO: what to do with the request?
        OutputStream os = httpExchange.getResponseBody();
		os.write(response.getBytes());

        httpExchange.close();
		os.close();

	}
}