package com.example.NeedYou.BookingManagement.model.Hiring;

import com.example.NeedYou.BookingManagement.model.Common.Location;
import com.example.NeedYou.BookingManagement.model.Common.TimePeriod;
import com.example.NeedYou.BookingManagement.model.Enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "hire_bookings")
@Getter
@Setter
public class HirePersonBooking {

    @Id
    private String id;

    private String serviceProviderId;

    private String customerId;

    private TimePeriod hiringPeriod;

    private Location workLocation;

    private BookingStatus status;

    private LocalDateTime bookedAt;
}