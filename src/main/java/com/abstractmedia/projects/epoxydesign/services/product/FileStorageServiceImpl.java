package com.abstractmedia.projects.epoxydesign.services.product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;



@Service
public class FileStorageServiceImpl implements FileStorageService {

	String S3_BUCKET_NAME = "epoxy-design-shop";

	String FOLDER = "images/";

	@Autowired
	AmazonS3 s3Client;

	@Override
	public void saveFile(MultipartFile multipartFile, String imgName) throws IOException {
		
		String key = FOLDER + imgName;
		File fileToUpload = convertFromMultiPartToFile(multipartFile);
		s3Client.putObject(new PutObjectRequest(S3_BUCKET_NAME, key, fileToUpload)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	@Override
	public void deleteFile(String fileName) throws Exception {
		s3Client.deleteObject(new DeleteObjectRequest(S3_BUCKET_NAME, FOLDER + fileName));
	}

	private File convertFromMultiPartToFile(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(multipartFile.getBytes());
		fos.close();
		return file;
	}

}