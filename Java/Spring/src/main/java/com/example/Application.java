package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ServletComponentScan
public class Application
{
	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);

//		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
//
//		String base64Key = Encoders.BASE64.encode(key.getEncoded());
//
//		System.out.println(base64Key);
	}
}
