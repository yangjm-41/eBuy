package com.ebuy.evaluation.service.impl;

import com.ebuy.evaluation.dao.EvaluationDao;
import com.ebuy.evaluation.entity.Evaluation;
import com.ebuy.evaluation.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {

    @Autowired
    private EvaluationDao evaluationDao;

    @Override
    public List<Evaluation> getEvaluationsByLimit(Evaluation limit) {
        return evaluationDao.selectByLimit(limit);
    }

    @Override
    public int modifyOrSaveEvaluation(Evaluation entity) {
        return evaluationDao.updateOrInsert(entity);
    }

    @Override
    public int deleteByIds(List<String> ids) {
        return evaluationDao.deleteByIds(ids);
    }
}
