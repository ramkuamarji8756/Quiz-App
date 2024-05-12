package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.model.QuestionWrapper;
import com.quiz.app.model.Response;
import com.quiz.app.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController 
{
	@Autowired
	QuizService quizService;
	
	
	//localhost:8080/questions/quiz/create?category=Java&numQ=5&title=JQuiz
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String title )
	{
		//return new ResponseEntity<>(" I am Here",HttpStatus.OK);
		return quizService.createQuiz(category,numQ,title);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id)
	{
		return quizService.getQuizQuestions(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer>submitQuiz(@PathVariable Integer id,@RequestBody List<Response>responses)
	{
		return quizService.calculateResult(id,responses);
	}
   
	
}
