package com.abstractmedia.projects.epoxydesign.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class DigitalOceanConfig {
	
	
	@Value("xxxxx")
	private String DO_SPACES_ACCESS_KEY;

	@Value("xxxxxxxx")
	private String DO_SPACES_ACCESS_SECRET;

	@Value("https://fra1.digitaloceanspaces.com")
	private String DO_SPACES_ENDPOINT;

	@Value("fra1")
	private String DO_SPACES_REGION;

	
	@Bean
	public AmazonS3 getCredentials() {
		BasicAWSCredentials creds = new BasicAWSCredentials(DO_SPACES_ACCESS_KEY, DO_SPACES_ACCESS_SECRET);
		return AmazonS3ClientBuilder
				.standard()
				.withEndpointConfiguration(new EndpointConfiguration(DO_SPACES_ENDPOINT, DO_SPACES_REGION))
				.withCredentials(new AWSStaticCredentialsProvider(creds)).build();
	}

}
