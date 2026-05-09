package com.example.NeedYou.BookingManagement.model.Rental;
import com.example.NeedYou.BookingManagement.model.Common.Location;
import com.example.NeedYou.BookingManagement.model.Common.RentalCharge;
import com.example.NeedYou.BookingManagement.model.Common.Skill;
import com.example.NeedYou.BookingManagement.model.Common.TimePeriod;
import com.example.NeedYou.BookingManagement.model.Enums.AvailabilityStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "people_rentals")
@Getter
@Setter
public class PeopleRental {

    @Id
    private String id;

    private String userId;

    private String fullName;

    private String profession;

    private List<Skill> skills;

    private RentalCharge rentalCharge;

    private TimePeriod availability;

    private String description;

    private Location location;

    private AvailabilityStatus status;
}