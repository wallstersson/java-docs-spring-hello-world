package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microsoft.applicationinsights.attach.ApplicationInsights;
import com.microsoft.applicationinsights.TelemetryClient;

@SpringBootApplication
@RestController
public class DemoApplication {
		
private static TelemetryClient telemetry = new TelemetryClient();

	public static void main(String[] args) {
		ApplicationInsights.attach();
		telemetry = new TelemetryClient();
		SpringApplication.run(DemoApplication.class, args);
	}

	@RequestMapping("/")
	String sayHello() {
		telemetry.trackEvent("Requested Hello Azure 2");
		return "Hello Azure 2!";
	}
}
