package com.choosr.item_picker_game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemPickerGameApplication {

	private static final Logger logger = LoggerFactory.getLogger(ItemPickerGameApplication.class);

	public static void main(String[] args) {
		logger.info("Starting application...");
		SpringApplication.run(ItemPickerGameApplication.class, args);
	}
}
