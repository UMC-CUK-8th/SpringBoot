package com.example.errornotifier.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class WebhookConfig {

	private final Logger logger = LoggerFactory.getLogger(WebhookConfig.class);

	@Bean
	@Profile({"local"})
	public WebhookEnabledMarker webhookEnabledMarker() {
		logger.info("로컬 환경: 웹훅 알림이 활성화되었습니다.");
		return new WebhookEnabledMarker(true);
	}

	@Bean
	@Profile({"dev", "prod", "default"})
	public WebhookEnabledMarker webhookDisabledMarker() {
		logger.info("개발/운영 환경: 웹훅 알림이 비활성화되었습니다.");
		return new WebhookEnabledMarker(false);
	}

	public static class WebhookEnabledMarker {
		private final boolean enabled;

		public WebhookEnabledMarker(boolean enabled) {
			this.enabled = enabled;
		}

		public boolean isEnabled() {
			return enabled;
		}
	}
}
