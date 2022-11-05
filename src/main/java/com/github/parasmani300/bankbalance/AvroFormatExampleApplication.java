package com.github.parasmani300.bankbalance;

import com.github.parasmani300.bankbalance.config.RootConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RootConfig.class})
public class AvroFormatExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroFormatExampleApplication.class, args);
	}

}
