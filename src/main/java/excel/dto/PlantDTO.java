package excel.dto;

import com.github.crab2died.annotation.ExcelField;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class PlantDTO {
    @ExcelField(title = "平台名称")
    String name ;
}
