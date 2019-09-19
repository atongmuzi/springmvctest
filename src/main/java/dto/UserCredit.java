package dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter@Getter
public class UserCredit {
    private int id;
    private Date create_time ;
    private Date update_time;
    private  int all_credit ;
    private  int remain_credit;

    @Override
    public String toString() {
        return "UserCredit{" +
                "id=" + id +
                ", all_credit=" + all_credit +
                ", remain_credit=" + remain_credit +
                ", used_credit=" + used_credit +
                '}';
    }

    private  int used_credit;

}
