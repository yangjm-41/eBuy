package com.ebuy.evaluation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ebuy.evaluation.entity.Evaluation;
import com.ebuy.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/{id}")
    public Evaluation getEvaluationById(@PathVariable(name = "id") String id){
        QueryWrapper<Evaluation> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        Evaluation evaluation = new Evaluation();
        evaluation.setId(id);
        Evaluation one = evaluationService.getOne(wrapper);
        return one;
    }

    @GetMapping("/user/{user_id}")
    public IPage<Evaluation> getEvaluationByUserId(@PathVariable(name = "user_id") String id){
        Page<Evaluation> page = new Page<>(1, 2);
        QueryWrapper<Evaluation> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", id);
        return evaluationService.page(page,wrapper);
    }

    @PostMapping
    public boolean saveEvaluation(Evaluation entity){
        return evaluationService.saveOrUpdate(entity);
    }

    @PutMapping
    public boolean modifyEvaluation(Evaluation entity){
        return evaluationService.saveOrUpdate(entity);
    }

    @DeleteMapping
    public boolean deleteEvaluations(List<Evaluation> entitys){
        if (entitys != null && entitys.isEmpty()){
            List<String> ids = entitys.stream().map(Evaluation::getId).collect(Collectors.toList());
            return evaluationService.removeByIds(ids);
        }
        return false;
    }
}
