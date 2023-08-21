package com.kh.app.schedule.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.app.schedule.entity.Calendar;
import com.kh.app.schedule.service.CalenService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Validated
@RequestMapping("/calendar.do")
public class CalendarController {
	
	@Autowired(required = false)
	private CalenService service;

	@GetMapping(params="method=list")
	public String list() {
		return "/schedule/fullcalendar";
	}
	
	@GetMapping(params = "method=data")
	@ResponseBody
	public ArrayList<Calendar> data(Model d) {
		ArrayList<Calendar> calList = service.calenList();
		log.debug("이게 뭐야 대체.... = {}", calList);
		d.addAttribute("list", service.calenList());
		return calList;
	}
 }