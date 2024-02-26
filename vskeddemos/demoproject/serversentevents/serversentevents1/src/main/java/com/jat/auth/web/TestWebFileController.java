package com.jat.auth.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.jat.auth.service.TestWebService;

@RestController
@RequestMapping("/test")
public class TestWebFileController {

	@Autowired
	private TestWebService testWebService;

	private static final Logger log = LoggerFactory.getLogger(TestWebController.class);

	@RequestMapping("/input")
	public String logUpload(@RequestParam("inputFile") MultipartFile[] fileArray,
			@RequestParam("inputText") String text, @RequestParam("inputTextarea") String textarea) throws Exception {
		if(log.isTraceEnabled()){
			log.trace("start");
		}

		String uploadResult=testWebService.testFileOutput(fileArray, text, textarea);

		if(log.isInfoEnabled()){
			log.info("uploadResult is:{}",uploadResult);
		}

		if(log.isTraceEnabled()){
			log.trace("end");
		}
		return uploadResult;
	}

}
