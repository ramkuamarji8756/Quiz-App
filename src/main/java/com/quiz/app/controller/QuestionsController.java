package com.quiz.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.app.model.Question;
import com.quiz.app.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionsController
{
	@Autowired
	QuestionService questionService;
	
	
   //localhost:8080/questions/question/allquestions
	@GetMapping("/allquestions")
	public ResponseEntity <List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}
	
	
	//localhost:8080/questions/question/category/Java
	@GetMapping("/category/{category}")
	public ResponseEntity<List<Question>> getAllQuestionsByCategory(@PathVariable String category)
	{
		return  questionService.getAllQuestionsByCategory(category);
		
	}
	
	//localhost:8080/questions/question/add
	@PostMapping("/add")
	public ResponseEntity<String> addQuestion(@RequestBody Question question) 
	{
		questionService.addQuestion(question);
		return questionService.addQuestion(question);
	}

}
