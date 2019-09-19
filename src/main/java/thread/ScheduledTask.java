package thread;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {
	// 每天凌晨两点执行 (0 0 2 * * ?) 秒，分钟，小时，天，月份 “?”字符只在日期域和星期域中使用。
	@Scheduled(cron = "10/3 * * * * ?") //每三秒执行一次
	void doSomethingWith() {
		System.out.println(Thread.currentThread().getName()+"do sometings ----"+System.currentTimeMillis());
		
	}
}
