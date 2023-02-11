package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

	public static void main(String[] args) {
		GenericWebApplicationContext webApplicationContext = new GenericWebApplicationContext();
		webApplicationContext.registerBean(HelloController.class);
		webApplicationContext.registerBean(SimpleHelloService.class);
		webApplicationContext.refresh();

		TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
		WebServer webServer = serverFactory.getWebServer(servletContext -> {
			servletContext.addServlet("dispatcherServlet",
				new DispatcherServlet(webApplicationContext)
			).addMapping("/*");
		});
		webServer.start();
	}

}