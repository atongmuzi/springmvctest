package junit;

import com.github.crab2died.ExcelUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import dto.UserCredit;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-db.xml"})
public class junitJdbcTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testJdbc(){
        String sql = "update user_credit set used_credit = ? where id = ? ";
        jdbcTemplate.update(sql,33,82);
        System.out.println(Thread.currentThread().getName()+"do sometings ----"+System.currentTimeMillis());
    }
    @Test
    public void testQueryOne(){
        String sql = "select * from user_credit where id = ?";
        RowMapper<UserCredit> result = new BeanPropertyRowMapper<>(UserCredit.class);
        UserCredit  userCredit = jdbcTemplate.queryForObject(sql,result,82);
        System.out.println(userCredit.toString());
    }
    @Test
    public void testQuetyAll(){
        String sql = "select * from user_credit";
        RowMapper<UserCredit> listResult = new BeanPropertyRowMapper<>(UserCredit.class);
        List<UserCredit> listUserCreadits = jdbcTemplate.query(sql,listResult);
        for (UserCredit userCreadit:listUserCreadits){
            System.out.println(userCreadit.toString());
        }

    }
}
