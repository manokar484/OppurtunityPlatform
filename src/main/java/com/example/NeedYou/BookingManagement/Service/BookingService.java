package com.example.NeedYou.BookingManagement.Service;

import com.example.NeedYou.Authentication.Configuration.UserDetailService;
import com.example.NeedYou.BookingManagement.Repository.ProductRentalRepository;
import com.example.NeedYou.BookingManagement.model.Rental.ProductRental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
   private ProductRentalRepository productRentalRepository;
    @Autowired
    private UserDetailService userDetailService;
    public  ProductRental addProductRental(ProductRental productRental)
    {
        productRental.setOwnerId(userDetailService.getId());
        productRentalRepository.save(productRental);
        return productRental;
    }
}
