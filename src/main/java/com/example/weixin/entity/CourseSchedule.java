package com.example.weixin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程进度实体
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSchedule implements Serializable {

    private Long id;
}
