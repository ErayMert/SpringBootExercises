package com.springboot.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.demo.model.Question;
import com.springboot.demo.service.SurveyService;

@RestController
public class SurveryController {

	@Autowired
	private SurveyService service;
	
	public SurveryController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveQuestionsForSurvey(@PathVariable String surveyId){
		
		return service.retrieveQuestions(surveyId);
	}
	
	@GetMapping("/surveys/{surveyId}/questions/{questionId}")
	public Question retrieveQuestion(@PathVariable String surveyId,@PathVariable String questionId) {
		
		return service.retrieveQuestion(surveyId, questionId);
	}
	
	@PostMapping("/surveys/{surveyId}/questions")
	public ResponseEntity<Void> addQuestionSurvey(@PathVariable String surveyId, @RequestBody Question newQuestion){
		
		Question question = service.addQuestion(surveyId, newQuestion);
		if(question == null)
			return ResponseEntity.noContent().build();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(question.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
