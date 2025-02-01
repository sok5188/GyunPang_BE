package com.gyunpang.be.service;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileService {
	private final Storage storage;
	@Value("${google.cloud.storage.bucket}")
	private String bucketName;

	public String uploadFile(MultipartFile file) throws IOException {
		// 파일을 로컬에 저장 후 Google Cloud Storage에 업로드
		Path tempFile = Files.createTempFile("upload-", ".tmp");
		Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

		// Google Cloud Storage에 업로드
		String blobName = "images/" + file.getOriginalFilename();  // 예시로 'images' 폴더에 저장
		BlobInfo blobInfo = BlobInfo.newBuilder(bucketName, blobName).build();
		storage.create(blobInfo, Files.readAllBytes(tempFile));

		// 업로드된 이미지의 URL을 반환
		return "https://storage.googleapis.com/" + bucketName + "/" + blobName;
	}

	public String getSignedUrl(String filename) {
		Blob blob = storage.get(bucketName, "images/" + filename);
		long expiration = System.currentTimeMillis() + TimeUnit.HOURS.toMillis(3);
		URL signedUrl = blob.signUrl(expiration, TimeUnit.MILLISECONDS);
		return signedUrl.toString();
	}

}
