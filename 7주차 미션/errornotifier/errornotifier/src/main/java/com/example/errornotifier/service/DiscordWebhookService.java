package com.example.errornotifier.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class DiscordWebhookService {

	private final Logger logger = LoggerFactory.getLogger(DiscordWebhookService.class);
	private final RestTemplate restTemplate;
	private final ObjectMapper objectMapper;

	@Value("${webhook.discord.url}")
	private String webhookUrl;

	@Value("${spring.profiles.active:unknown}")
	private String activeProfile;

	public DiscordWebhookService(RestTemplate restTemplate, ObjectMapper objectMapper) {
		this.restTemplate = restTemplate;
		this.objectMapper = objectMapper;
	}

	public void sendErrorNotification(String errorMessage, String requestUrl, String stackTrace) {
		// 로컬 환경에서만 알림을 보냄 (dev, prod는 보내지 않음)
		if (!"local".equals(activeProfile)) {
			logger.info("현재 프로파일이 {}이므로 알림을 발송하지 않습니다.", activeProfile);
			return;
		}

		logger.info("현재 프로파일이 local이므로 알림을 발송합니다.");

		try {
			Map<String, Object> message = new HashMap<>();
			message.put("content", "⚠️ **서버에서 500 에러가 발생했습니다! (로컬 테스트)**");

			Map<String, Object> embed = new HashMap<>();
			embed.put("title", "오류 상세 정보");
			embed.put("color", 16711680); // 빨간색

			Map<String, String> field1 = new HashMap<>();
			field1.put("name", "요청 URL");
			field1.put("value", requestUrl);
			field1.put("inline", "true");

			Map<String, String> field2 = new HashMap<>();
			field2.put("name", "발생 시각");
			field2.put("value", java.time.LocalDateTime.now().toString());
			field2.put("inline", "true");

			Map<String, String> field3 = new HashMap<>();
			field3.put("name", "에러 메시지");
			field3.put("value", errorMessage);
			field3.put("inline", "false");

			Map<String, String> field4 = new HashMap<>();
			field4.put("name", "활성 프로파일");
			field4.put("value", "로컬 테스트");
			field4.put("inline", "true");

			embed.put("fields", new Object[]{field1, field2, field3, field4});

			message.put("embeds", new Object[]{embed});

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<String> request = new HttpEntity<>(objectMapper.writeValueAsString(message), headers);

			restTemplate.postForEntity(webhookUrl, request, String.class);
			logger.info("디스코드 알림 발송 완료");
		} catch (Exception e) {
			logger.error("디스코드 웹훅 알림 전송 실패: {}", e.getMessage(), e);
		}
	}
}
