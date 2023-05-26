package com.ezen;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ezen.dto.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/sample")
@Log4j2
public class SampleController {
	
	public SampleController() {
		System.out.println("Sample 컨트롤러 생성......");
	}

	@GetMapping("/ex1")
	public void ex1() {
		log.info("ex1................");
	}
	
	@GetMapping("/ex2")
	public void exModel(Model model) {
		List<SampleDTO> list = new ArrayList<>();
		for(int i=1; i<=20; i++) {
			SampleDTO dto = SampleDTO.builder()
					.sno((long)i)
					.first("First...." + i)
					.last("Last..." + i)
					.regTime(LocalDateTime.now())
					.build();
			
			list.add(dto);
		}
		
		model.addAttribute("list", list);
	}
}
