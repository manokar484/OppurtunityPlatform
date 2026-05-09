package com.example.NeedYou.BookingManagement.Repository;

import com.example.NeedYou.BookingManagement.model.Rental.ProductRental;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRentalRepository extends MongoRepository<ProductRental,String > {

}
