package com.daotiger.dododex.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DataController {

	/**
	 * 日志
	 */
	public Logger logger=LoggerFactory.getLogger(getClass());

	@Value(value="classpath:data.json")
	private  Resource resource;

	@RequestMapping(value="/api/data" ,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String index() {
		logger.info("kaishi");
		String data = readToString("data.json");
		return data;
	}
	private String readToString(String fileName) {

		Resource resource = new ClassPathResource(fileName);
		BufferedReader br;
		StringBuffer message = new StringBuffer();
		try {
			br = new BufferedReader(new InputStreamReader(resource.getInputStream(),"UTF-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				message.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String defaultString = message.toString();
		return defaultString;
	}

}
