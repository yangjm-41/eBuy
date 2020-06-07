package com.ebuy.evaluation.service;

import com.ebuy.evaluation.entity.Evaluation;

import java.util.List;

public interface EvaluationService {
    List<Evaluation> getEvaluationsByLimit(Evaluation limit);

    int modifyOrSaveEvaluation(Evaluation entity);

    int deleteByIds(List<String> ids);
}
