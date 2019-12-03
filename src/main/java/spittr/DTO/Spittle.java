package spittr.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter@Setter
public class Spittle {
    private Long id;
    private String message ;
    private Date time;
    private Double latitude;

    private Double longitude;
    public Spittle(String message,Date time){
        this(message,time,null,null);
    }
    public Spittle(String message,Date time,Double latitude,Double longitude){
        this.id = null;
        this.message = message;
        this.time = time ;
        this.latitude = latitude;
        this.longitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spittle spittle = (Spittle) o;
        return message.equals(spittle.message) &&
                time.equals(spittle.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time);
    }
}
