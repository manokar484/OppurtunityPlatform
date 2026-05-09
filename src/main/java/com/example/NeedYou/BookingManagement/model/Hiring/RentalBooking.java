package com.example.NeedYou.BookingManagement.model.Hiring;
import com.example.NeedYou.BookingManagement.model.Common.Location;
import com.example.NeedYou.BookingManagement.model.Common.TimePeriod;
import com.example.NeedYou.BookingManagement.model.Enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "rental_bookings")
@Getter
@Setter
public class RentalBooking {

    @Id
    private String id;

    private String rentalId;

    private String ownerId;

    private String bookedByUserId;

    private TimePeriod bookingPeriod;

    private Location deliveryLocation;

    private BookingStatus status;

    private LocalDateTime bookedAt;
}