package com.qrcodegenerator;

import com.qrcodegenerator.service.IQRCodeGenerationService;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class QrcodeGeneratorApplication implements CommandLineRunner {

	@Autowired
	IQRCodeGenerationService qrCodeGenerationService;

	public static void main(String[] args) {
		SpringApplication.run(QrcodeGeneratorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		while (true){
			Scanner scanner = new Scanner(System.in);
			log.info("Enter your message: ");
			String inputMessage = scanner.nextLine();

			log.info("Input Message from console - {}", inputMessage);
			if (StringUtils.isNotBlank(inputMessage)) {
				qrCodeGenerationService.generateQRCode(inputMessage);
			}
		}
	}
}
