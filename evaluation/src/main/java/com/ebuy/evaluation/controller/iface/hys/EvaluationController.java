package com.ebuy.evaluation.controller.iface.hys;

import com.ebuy.evaluation.entity.Evaluation;
import com.ebuy.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/{id}")
    public List<Evaluation> getEvaluationById(@PathVariable(name = "id") String id){
        Evaluation evaluation = new Evaluation();
        evaluation.setId(id);
        return evaluationService.getEvaluationsByLimit(evaluation);
    }

    @GetMapping("/user/{user_id}")
    public List<Evaluation> getEvaluationByUserId(@PathVariable(name = "user_id") String id){
        Evaluation evaluation = new Evaluation();
        evaluation.setUser_id(id);
        return evaluationService.getEvaluationsByLimit(evaluation);
    }

    @PostMapping
    public int saveEvaluation(Evaluation entity){
        return evaluationService.modifyOrSaveEvaluation(entity);
    }

    @PutMapping
    public int modifyEvaluation(Evaluation entity){
        return evaluationService.modifyOrSaveEvaluation(entity);
    }

    @DeleteMapping
    public int deleteEvaluations(List<Evaluation> entitys){
        if (entitys.isEmpty())
    }
}
