package tobyspring.helloboot;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HellobootApplication {

	public static void main(String[] args) {
		// 스프링 컨테이너를 생성, 빈을 등록하고 초기화
		GenericWebApplicationContext webApplicationContext = new GenericWebApplicationContext() {
			@Override
			protected void onRefresh() {
				super.onRefresh();
				// 스프링 컨테이너를 활용해서 서블릿 컨테이너를 만들고, 필요한 디스패처 서블릿을 등록하는 서블릿 컨테이너 초기화
				TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
				WebServer webServer = serverFactory.getWebServer(servletContext -> {
					servletContext.addServlet("dispatcherServlet",
						new DispatcherServlet(this)
					).addMapping("/*");
				});
				webServer.start();
			}
		};
		webApplicationContext.registerBean(HelloController.class);
		webApplicationContext.registerBean(SimpleHelloService.class);
		webApplicationContext.refresh();
	}

}