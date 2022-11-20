package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microsoft.applicationinsights.TelemetryClient;

@SpringBootApplication
@RestController
public class DemoApplication {
		
	private TelemetryClient telemetry = new TelemetryClient();

	public static void main(String[] args) {
		ApplicationInsights.attach();
		telemetry.getContext().getUser().setId("1234");
		telemetry.getContext().getDevice().setId("12345");

		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		telemetry.trackEvent("Requested Hello Azure");
		return "Hello Azure!";
	}
}
