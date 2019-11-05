package junit;


import config.DatasourceConfig;
import excel.ExcleUtils;
import excel.dto.PlantDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DatasourceConfig.class)
@ActiveProfiles("qa")
public class junitExcelTest {
    @Autowired
    ExcleUtils excleUtils;

    @Test
    public  void test(){
        String path = System.getProperty("user.dir")+ File.separator+"data"+File.separator+"plantname.xlsx";

        List<PlantDTO> plantDTOList = excleUtils.excelRead(path,PlantDTO.class);
        System.out.println("test");
    }
}
