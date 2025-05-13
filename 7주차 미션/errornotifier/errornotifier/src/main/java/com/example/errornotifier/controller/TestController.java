package com.example.errornotifier.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

	@Value("${spring.profiles.active:unknown}")
	private String activeProfile;

	@GetMapping("/test-error")
	public String testError() {
		// 강제로 예외 발생
		throw new RuntimeException("테스트용 500 에러 발생 (프로파일: " + activeProfile + ")");
	}

	@GetMapping("/profile")
	public Map<String, String> checkProfile() {
		Map<String, String> result = new HashMap<>();
		result.put("profile", activeProfile);
		result.put("message", "현재 활성화된 프로파일: " + activeProfile);

		// 로컬 환경인지 확인하여 알림 가능 여부 표시
		if ("local".equals(activeProfile)) {
			result.put("webhook", "활성화 상태 - 알림을 보냅니다");
		} else {
			result.put("webhook", "비활성화 상태 - 알림을 보내지 않습니다");
		}

		return result;
	}
}
