package com.ebuy.evaluation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ebuy.evaluation.dao.EvaluationDao;
import com.ebuy.evaluation.entity.Evaluation;
import com.ebuy.evaluation.service.EvaluationService;
import org.springframework.stereotype.Service;

@Service
public class EvaluationServiceImpl extends ServiceImpl<EvaluationDao, Evaluation> implements EvaluationService {

}
