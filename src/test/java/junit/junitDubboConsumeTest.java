package junit;


import com.testfan.service.inf.ComputeService;
import config.DatasourceConfigDubbo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("qa")
@ContextConfiguration(classes = DatasourceConfigDubbo.class)
public class junitDubboConsumeTest {
    @Resource
    public ComputeService computeService;

    @Test
    public void test(){
       int result= computeService.add(1,2);
        System.out.println(result);
    }
}
