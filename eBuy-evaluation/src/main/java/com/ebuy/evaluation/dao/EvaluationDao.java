package com.ebuy.evaluation.dao;

import com.ebuy.evaluation.entity.Evaluation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EvaluationDao {

    @Select({"<script>",
                "select * from tb_evaluation ",
                "where 1 = 1 ",
                    "<if test='id != null'> and id = #{id} </if>",
                    "<if test='merchant_id != null'> and merchant_id = #{merchant_id} </if>",
                    "<if test='user_id != null'> and  user_id = #{user_id} </if>",
                    "<if test='level != null'> and  level = #{level} </if>",
            "</script>"})
    List<Evaluation> selectByLimit(Evaluation limit);

    @Insert({"<script>",
                    "insert into tb_evaluation(id, user_id, merchant_id, content, level)",
                    "values(#{id}, #{user_id}, #{merchant_id}, #{content}, #{level})",
                    "ON DUPLICATE KEY UPDATE",
                        "<if test='content != null'> set content = #{content} </if>",
                        "<if test='level != null'> set content = #{level} </if>",
            "</script>"})
    int updateOrInsert(Evaluation entity);

    @Delete({"<script>",
                "delete from tb_evaluation",
                "where id in ",
                    "<foreach item='item' collection='list' separator=',' open='(' close=')' >",
                        "#{item}",
                    "</foreach>",
            "</script>"})
    int deleteByIds(List<String> ids);
}
