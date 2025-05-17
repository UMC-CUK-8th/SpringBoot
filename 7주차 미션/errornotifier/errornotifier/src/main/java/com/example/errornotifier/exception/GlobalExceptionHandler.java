package com.example.errornotifier.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.example.errornotifier.service.DiscordWebhookService;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	private final DiscordWebhookService discordWebhookService;

	@Value("${spring.profiles.active:unknown}")
	private String activeProfile;

	public GlobalExceptionHandler(DiscordWebhookService discordWebhookService) {
		this.discordWebhookService = discordWebhookService;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex, WebRequest request, HttpServletRequest httpRequest) {
		// 스택 트레이스를 문자열로 변환
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		String stackTrace = sw.toString();

		// 요청 URL 추출
		String requestUrl = httpRequest.getRequestURL().toString();
		if (httpRequest.getQueryString() != null) {
			requestUrl += "?" + httpRequest.getQueryString();
		}

		logger.error("에러 발생 - 프로파일: {}, URL: {}, 메시지: {}",
			activeProfile, requestUrl, ex.getMessage());

		// 디스코드로 에러 알림 전송 (DiscordWebhookService에서 프로필 체크)
		discordWebhookService.sendErrorNotification(ex.getMessage(), requestUrl, stackTrace);

		// 클라이언트에게는 일반적인 오류 메시지 반환
		return ResponseEntity
			.status(HttpStatus.INTERNAL_SERVER_ERROR)
			.body("서버 내부 오류가 발생했습니다. (프로파일: " + activeProfile + ")");
	}
}
