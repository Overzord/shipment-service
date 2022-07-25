package com.shipment.shipmentservice.dao;

import com.shipment.shipmentservice.model.ShipmentLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentLineRepository extends JpaRepository<ShipmentLine, Long> {

  @Query(value = "SELECT * from shipment_line shl where shl.id = :id ", nativeQuery = true)
  ShipmentLine getById(@Param(value = "id") Long id);
}
