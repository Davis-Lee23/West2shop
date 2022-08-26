package com.config;

import com.job.MessageJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月26日 10:06
 */
@Configuration
public class QuartzConfig {

    /**
     * 实体类名称
     */
    private static final String TRIGGER_GROUP_NAME = "MESSAGE_TRIGGER_GROUP_NAME";
    private static final String MESSAGE_NAME = "MESSAGE_NAME";


    /**
    * TODO 创建Quartz的Job
    * @author: LZP
    * @date: 2022/8/26 10:15
    * @return: org.quartz.JobDetail
    */
    @Bean
    public JobDetail syncMessageDetail()
    {
        JobDetail jobDetail = JobBuilder.newJob(MessageJob.class)
/*                .withIdentity("syncUserJobDetail",JOB_GROUP_NAME)
                .usingJobData("Remark","欢迎访问")*/
                //即使没有Trigger关联时，也不需要删除该JobDetail
                .storeDurably()
                .build();
        return jobDetail;
    }

    /**
     * 定时任务：
     * 同步用户信息Job（触发器）
     */
/*    @Bean
    public Trigger syncUserJobTrigger() {
        //每隔5秒执行一次,此处创建了一个Schedule
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        //创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                //关联上述的MessageDetail
                .forJob(syncMessageDetail())
                //给Trigger起个名字
                .withIdentity("MessageGroup", TRIGGER_GROUP_NAME)
                .withSchedule(cronScheduleBuilder)
                .build();
        return trigger;

    }*/
}
