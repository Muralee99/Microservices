package com.firstdelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.firstdelivery.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long>{

}
