package spittr.Service;

import spittr.DTO.Spittle;
import java.util.*;

public interface SpittleResposiory {
    List<Spittle> findSpittles(long max,int count);
}
