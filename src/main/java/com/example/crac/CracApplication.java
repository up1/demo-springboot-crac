package com.example.crac;

import org.crac.Context;
import org.crac.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.SmartLifecycle;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CracApplication {

	public static void main(String[] args) {
		SpringApplication.run(CracApplication.class, args);
	}

}

@Component
class StatefulComponent implements SmartLifecycle {

	@Override
	public void start() {

	}

	@Override
	public void stop() {

	}

	@Override
	public boolean isRunning() {
		return false;
	}
}
