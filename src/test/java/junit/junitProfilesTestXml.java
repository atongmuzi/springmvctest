package junit;


import config.DatasourceConfig;
import config.DatasourceConfigXml;
import config.Tadmin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import templete.DBUtilsTemplate;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatasourceConfigXml.class)
@ActiveProfiles("qa")
public class junitProfilesTestXml {
    @Autowired
    DBUtilsTemplate dbUtilsTemplate;
    @Autowired
    Environment env;
    @Test
    public void activeprofiles(){


        String[] envs = env.getActiveProfiles();
        String sql = "select * from admin where id = ?";
        List<Tadmin> tadmin = dbUtilsTemplate.find(Tadmin.class,sql,23);
        System.out.println(tadmin);
    }
}
