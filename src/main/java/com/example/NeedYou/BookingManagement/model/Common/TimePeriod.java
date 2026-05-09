package com.example.NeedYou.BookingManagement.model.Common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TimePeriod {
    LocalDateTime from;
    LocalDateTime to;
}
