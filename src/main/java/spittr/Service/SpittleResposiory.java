package spittr.Service;

import org.springframework.stereotype.Controller;
import spittr.DTO.Spittle;
import java.util.*;

@Controller
public interface SpittleResposiory {
    List<Spittle> findSpittles(long max,int count);

}
