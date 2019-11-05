package excel;

import com.github.crab2died.ExcelUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExcleUtils {

    public  <T> List<T> excelRead(String path,Class<T> tClass){
        List<T> dtoList = new ArrayList<>();
        try {
                dtoList = ExcelUtils.getInstance().readExcel2Objects(path,tClass);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }
}
