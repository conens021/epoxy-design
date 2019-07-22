package com.abstractmedia.projects.epoxydesign.services.product;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

	void saveFile(MultipartFile multipartFile, String fileName) throws IOException;

	void deleteFile(String fileName) throws Exception;
}