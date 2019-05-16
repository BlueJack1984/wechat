package com.example.weixin.service.page;

import com.example.weixin.entity.CourseSchedule;
import com.example.weixin.entity.Hardware;
import com.example.weixin.entity.Order;
import com.example.weixin.entity.User;

public interface IPersonalService {

    /**
     * 获取我的课程进度
     * @param userId 表示用户id
     * @param courseId 表示课程id
     * @return 返回获取的课程进度信息
     */
    CourseSchedule getCourseSchedule(Long userId, Long courseId);

    /**
     * 获取我的关联硬件
     * @param userId 表示用户id
     * @return 返回获取的关联硬件信息
     */
    Hardware getHardware(Long userId);

    /**
     * 获取我的订单信息
     * @param userId 表示用户id
     * @return 返回获取的订单信息
     */
    Order getOrder(Long userId);

    /**
     * 获取我的账号信息
     * @param userId 表示用户id
     * @return 返回获取的账号信息
     */
    User getUser(Long userId);
}
