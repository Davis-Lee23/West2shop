package com.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月26日 10:03
 */
public class MessageJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取JobDetail中传递的参数
        System.out.println("定时器启动成功-------------");
    }
}
