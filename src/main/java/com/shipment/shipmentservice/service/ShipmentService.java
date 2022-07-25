package com.shipment.shipmentservice.service;


import com.shipment.shipmentservice.model.DeliveryAddress;
import com.shipment.shipmentservice.model.Shipment;

public interface ShipmentService {
  Shipment addShipment(Shipment shi);

  Shipment getShipmentByShipmentNumber(String shipmentNumber);

  Shipment updateShipment(String shipmentNumber, Shipment shipment);

  void deleteShipmentByNumber(String shipmentNumber);
}
