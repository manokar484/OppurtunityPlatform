package com.example.NeedYou.BookingManagement.model.Rental;

import com.example.NeedYou.BookingManagement.model.Common.Location;
import com.example.NeedYou.BookingManagement.model.Common.RentalCharge;
import com.example.NeedYou.BookingManagement.model.Common.TimePeriod;
import com.example.NeedYou.BookingManagement.model.Enums.AvailabilityStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rentals")
@Getter
@Setter
public class ProductRental {

    @Id
    private String id;

    private String ownerId;

    private String productName;

    private String productCategory;

    private String description;

    private RentalCharge rentalCharge;

    private TimePeriod availability;

    private Location location;

    private AvailabilityStatus status;
}