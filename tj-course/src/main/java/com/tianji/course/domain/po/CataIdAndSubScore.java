package com.tianji.course.domain.po;

import lombok.Data;

/**
 * 查询某个课程中练习对应的练习id和该练习对应的题目id
 * @ClassName CataIdAndSubScore
 * @Author wusongsong
 * @Date 2022/7/22 16:04
 * @Version
 **/
@Data
public class CataIdAndSubScore {
    //练习id
    private Long cataId;
    //题目id
    private Long subjectId;
    //题目对应的分
    private Integer score;
}