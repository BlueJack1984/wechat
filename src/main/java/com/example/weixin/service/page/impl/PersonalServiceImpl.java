package com.example.weixin.service.page.impl;

import com.example.weixin.entity.CourseSchedule;
import com.example.weixin.entity.Hardware;
import com.example.weixin.entity.Order;
import com.example.weixin.entity.User;
import com.example.weixin.service.page.IPersonalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 个人中心服务
 * @author lushusheng
 * @date 2019-5-16
 */
@Service
@Slf4j
public class PersonalServiceImpl implements IPersonalService {

    /**
     * 获取我的课程进度
     * @param userId 表示用户id
     * @param courseId 表示课程id
     */
    @Override
    public CourseSchedule getCourseSchedule(Long userId, Long courseId) {
        //http协议调用后台获取
        return null;
    }

    /**
     * 获取我的关联硬件
     * @param userId 表示用户id
     * @return 返回获取的关联硬件信息
     */
    @Override
    public Hardware getHardware(Long userId) {
        //http协议调用后台获取
        return null;
    }

    /**
     * 获取我的订单信息
     * @param userId 表示用户id
     * @return 返回获取的订单信息
     */
    @Override
    public Order getOrder(Long userId) {
        //http协议调用后台获取
        return null;
    }

    /**
     * 获取我的账号信息
     * @param userId 表示用户id
     * @return 返回获取的账号信息
     */
    @Override
    public User getUser(Long userId) {
        //http协议调用后台获取
        return null;
    }
}
