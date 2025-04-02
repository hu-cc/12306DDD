package cn.hu12306.domain;

import cn.hu12306.SeatTypeEnum;
import cn.hu12306.outer.Station;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author hcc
 */
@Setter
@Getter
@Builder
public class Ticket {

    @NonNull private Station fromStation;
    @NonNull private LocalDateTime departureTime;
    @NonNull private Station toStation;
    @NonNull private LocalDateTime arrivalTime;
    @NonNull private SeatTypeEnum seat;

}
