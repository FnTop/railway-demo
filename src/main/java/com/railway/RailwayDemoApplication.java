package com.railway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.context.WebServerApplicationContext;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.boot.web.server.WebServer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController("/")
public class RailwayDemoApplication implements ApplicationListener<WebServerInitializedEvent> {
	private static final Logger log = LoggerFactory.getLogger(RailwayDemoApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(RailwayDemoApplication.class, args);
	}

	@PostMapping("/hello")
	public String hello() {
		return "LiangLinTing";
	}

	@Override
	public void onApplicationEvent(WebServerInitializedEvent event) {
		WebServer server = event.getWebServer();
		WebServerApplicationContext context = event.getApplicationContext();
		Environment env = context.getEnvironment();
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			log.error("获取ip异常");
		}
		int port = server.getPort();
		String contextPath = env.getProperty("server.servlet.context-path");
		if (contextPath == null) {
			contextPath = "";
		}
		log.info("\n---------------------------------------------------------\n" +
				"\tApplication is running! Access address:\n" +
				"\tLocal:\t\thttp://localhost:{}" +
				"\n\tExternal:\thttp://{}:{}{}" +
				"\n---------------------------------------------------------\n", port, ip, port, contextPath);
	}
}
