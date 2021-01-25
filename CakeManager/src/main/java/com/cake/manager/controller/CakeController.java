package com.cake.manager.controller;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cake.manager.dto.CakeDTO;
import com.cake.manager.service.interfaces.CakeService;
import com.cake.manager.util.Validations;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class CakeController {
	
	private static final Logger log = LogManager.getLogger(CakeController.class);
	
	@Autowired
	CakeService cakeService;

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView getCakes() throws Exception {
		List<CakeDTO> oListCakes = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView("index");

		try {
			oListCakes = cakeService.findAll();
			log.info("Cakes Retrieved Properly");
		} catch (Exception ex) {
			log.error("Error getCakes. Cause: " + ex.getMessage());
			throw new Exception("Data can not be retrieved. Cause: " + ex.getMessage());
		}
		modelAndView.addObject("cakes", oListCakes);
		return modelAndView;
	}

	@PostMapping(value = "/cakes", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ModelAndView postCakes(final CakeDTO newCake) throws Exception {

		log.info("postCakes-- ");
		List<CakeDTO> oListCakes = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView("index");
		int newCakeId = 0;
		CakeDTO oCake = new CakeDTO();
		
		String sError = "";

		try {
			
			// Basic Validations
			sError = Validations.validateNulls(newCake);
			if (sError.isEmpty()) {
				oCake = cakeService.findByName(newCake.getCakeName().trim());
				if(oCake!=null) {
					sError = Validations.validateCakeAlreadyExists(oCake);
				}
			}

			if (sError.isEmpty()) {
			newCakeId = cakeService.insert(newCake);
			log.info("Cake " + newCakeId + " inserted Properly");
			}else {
				
			}
			oListCakes = cakeService.findAll();
			log.info("Cakes Retrieved Properly");

		} catch (Exception ex) {
			log.error("Error postCakes. Cause: " + ex.getMessage());
			sError = "Error postCakes. Cause: " + ex.getMessage();
		}

		modelAndView.addObject("cakes",oListCakes);
		modelAndView.addObject("error",sError);
		return modelAndView;
	}

	@GetMapping(value = "/cakes", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public String getCakesToFileJson(HttpServletResponse response) throws Exception {
		log.info("getCakesToJson-- ");

		List<CakeDTO> oListCakes = new ArrayList<CakeDTO>();
		String sJSONData = "";

		try {
			oListCakes = cakeService.findAll();
			log.info("Cakes Retrieved Properly");
		} catch (Exception ex) {
			log.error("Error getCakes. Cause: " + ex.getMessage());
			throw new Exception("Error. Cause: " + ex.getMessage());
		}
		
		//Generate File
		try {

			ObjectMapper mapper = new ObjectMapper();
			sJSONData = mapper.writeValueAsString(oListCakes);

			response.setContentType("text/plain");
			response.setHeader("Content-Disposition", "attachment;filename=cakes_download.txt");
			ServletOutputStream out = response.getOutputStream();
			out.println(sJSONData);
			out.flush();
			out.close();

		} catch (IOException ex) {
			log.error("Error writing file to output stream.Filename was == > " + ex.getMessage());
		}

		return null;
	}
	
	
	
}
