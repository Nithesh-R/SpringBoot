package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		if (!isPortAvailable(8080)) {
			System.out.println("Port 8080 is already in use. Exiting...");
			System.exit(1);
		}

		SpringApplication.run(DemoApplication.class, args);
	}

	private static boolean isPortAvailable(int port) {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			serverSocket.setReuseAddress(true);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

}
