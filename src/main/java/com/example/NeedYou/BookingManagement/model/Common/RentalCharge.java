package com.example.NeedYou.BookingManagement.model.Common;


import com.example.NeedYou.BookingManagement.model.Enums.ChargeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalCharge {

    private double amount;
    private ChargeType chargeType;
}
