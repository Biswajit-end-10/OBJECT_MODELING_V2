package com.crio.codingame.services;


import java.util.List;

import com.crio.codingame.entities.Level;
import com.crio.codingame.entities.Question;
import com.crio.codingame.repositories.IQuestionRepository;

public class QuestionService implements IQuestionService{
    private final IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question create(String title, Level level, Integer difficultyScore) {
     final Question question = new Question(title,level, difficultyScore);
        return questionRepository.save(question);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Get All Questions if level is not specified.
    // Or
    // Get List of Question which matches the level provided.

    @Override
    public List<Question> getAllQuestionLevelWise(Level level) {
        if (level == null) {
            // If level is not specified, return all questions.
            return questionRepository.findAll();
        } else {
            // If level is specified, return questions matching the provided level.
            return questionRepository.findAllQuestionLevelWise(level);
     
    }
    
}


    @Override
    public List<Question> findByLevel(Level level) {
        // TODO Auto-generated method stub
        return questionRepository.findByLevel(level);
    }
}
