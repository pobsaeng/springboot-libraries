package com.infotech.app.injection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MsgInjection {
	@Value(value = "${msg.error}")
	private String error;
	@Value(value = "${msg.warning}")
	private String warning;
	@Value(value = "${msg.alert}")
	private String alert;
	@Value(value = "${msg.text}")
	private String text;
	
	public String getError() {
		return error;
	}
	public String getWarning() {
		return warning;
	}
	public String getAlert() {
		return alert;
	}
	public String getText() {
		return text;
	}
}
