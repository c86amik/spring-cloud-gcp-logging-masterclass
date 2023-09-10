/**
 * 
 */
package com.springcavaj.gcp.logger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcavaj.gcp.logger.model.User;
import com.springcavaj.gcp.logger.service.SpringGCPLoggerValidationService;


/**
 * @author c86am
 *
 */

@RestController
public class SpringGCPLoggerController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringGCPLoggerController.class);
	
	private final SpringGCPLoggerValidationService gcpLoggerValidationService;
	
	@Autowired
	public SpringGCPLoggerController(SpringGCPLoggerValidationService gcpLoggerValidationService) {
		this.gcpLoggerValidationService = gcpLoggerValidationService;
	}
	
	
	@GetMapping("/logUsers")
    public void logUsersData() {
		LOGGER.info("logUsersData() -> Logs all Users data");
		User user = new User();
		user.setUserId(1);
		user.setName("Test");
		user.setMobileNo("1234567890");
		LOGGER.info("logUsersData() -> 1st level logging for proper User");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
		user = new User();
		user.setName("Test");
		user.setMobileNo("1234567890");
		LOGGER.info("logUsersData() -> 2nd level logging for not proper User having no userId");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
		user = new User();
		user.setUserId(1);
		user.setMobileNo("1234567890");
		LOGGER.info("logUsersData() -> 3rd level logging for not proper User having no name");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
		user = new User();
		user.setUserId(1);
		user.setName("Test");
		LOGGER.info("logUsersData() -> 4th level logging for not proper User having no mobile no.");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
		user = new User();
		user.setUserId(1);
		user.setName("Test");
		user.setMobileNo("123456789012");
		LOGGER.info("logUsersData() -> 5th level logging for not proper User having mobileNo greater than 10 digits");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
		user = new User();
		user.setUserId(1);
		user.setName("Test");
		user.setMobileNo("12345678");
		LOGGER.info("logUsersData() -> 6th level logging for not proper User having mobileNo lesser than 10 digits");
		checkValidateUser(gcpLoggerValidationService.validateUser(user), user);
    }
	
	private void checkValidateUser(Boolean isValid, User user) {
		if(isValid) {
			LOGGER.info("checkValidateUser() -> User is valid : {}", user);
		} else {
			LOGGER.error("checkValidateUser() -> User is invalid : {}", user);
		}
	}
} 
