package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestExecutionListeners;

@Component
public class jdbcTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    int i = 2;
    @Scheduled(cron = "0 0 1 * * ?") //每三秒执行一次
    public void toUpdate(){

        String sql = "update user_credit set used_credit = ? where id = ? ";
        jdbcTemplate.update(sql,i,82);
        i++;
        System.out.println(Thread.currentThread().getName()+"do sometings ----"+System.currentTimeMillis());
    }


}
