package com.shipment.shipmentservice.dao;

import com.shipment.shipmentservice.model.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {

  @Query(value = "SELECT * from delivery_address shl where shl.id = :id ", nativeQuery = true)
  DeliveryAddress getById(Long id);
}
