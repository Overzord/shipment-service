package com.shipment.shipmentservice.dao;

import com.shipment.shipmentservice.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

  Shipment findByShipmentNumber(String shipmentNumber);

  void deleteById(Long id);

}
