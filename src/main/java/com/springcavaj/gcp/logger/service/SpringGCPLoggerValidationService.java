/**
 * 
 */
package com.springcavaj.gcp.logger.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.springcavaj.gcp.logger.model.User;

/**
 * @author c86am
 *
 */
@Service
public class SpringGCPLoggerValidationService {
	private Logger LOGGER = LoggerFactory.getLogger(SpringGCPLoggerValidationService.class);
	
	public Boolean validateUser(User user) {
		Boolean isValid = Boolean.TRUE;
		if(null == user) {
			LOGGER.error("validateUser() -> User is null");
			return Boolean.FALSE;
		} else {
			if(null != user.getUserId() && StringUtils.hasText(user.getName()) && StringUtils.hasText(user.getMobileNo())) {
				LOGGER.info("validateUser() -> userId : {}, userName : {}, userMobile : {}", user.getUserId(), user.getName(), user.getMobileNo());
				return isValid;
			} else {
				if(null == user.getUserId()) {
					LOGGER.error("validateUser() -> UserId is null");
					return Boolean.FALSE;
				} if(!StringUtils.hasText(user.getName())) {
					LOGGER.error("validateUser() -> User Name is blank");
					return Boolean.FALSE;
				} if(!StringUtils.hasText(user.getMobileNo())) {
					LOGGER.error("validateUser() -> User Mobile is blank");
					return Boolean.FALSE;
				} if(user.getMobileNo().length() < 10 || user.getMobileNo().length() > 10) {
					LOGGER.error("validateUser() -> User Mobile No is {} digits", user.getMobileNo().length());
					return Boolean.FALSE;
				}
			}
		}
		return Boolean.FALSE;
	}
}
