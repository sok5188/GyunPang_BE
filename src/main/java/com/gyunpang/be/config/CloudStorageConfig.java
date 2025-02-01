package com.gyunpang.be.config;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Configuration
public class CloudStorageConfig {

	@Bean
	public Storage getStorageClient() throws IOException {
		// JSON 형식의 서비스 계정 키 파일로 인증 처리
		GoogleCredentials credentials = GoogleCredentials.fromStream(
			new FileInputStream("src/main/resources/cloud_storage_iam.json"));

		// 인증된 credentials를 사용하여 Storage 객체 생성
		return StorageOptions.newBuilder().setCredentials(credentials).build().getService();
	}
}
