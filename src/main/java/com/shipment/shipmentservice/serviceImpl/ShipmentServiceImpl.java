package com.shipment.shipmentservice.serviceImpl;

import com.shipment.shipmentservice.dao.DeliveryAddressRepository;
import com.shipment.shipmentservice.dao.ShipmentLineRepository;
import com.shipment.shipmentservice.dao.ShipmentRepository;
import com.shipment.shipmentservice.model.DeliveryAddress;
import com.shipment.shipmentservice.model.Shipment;
import com.shipment.shipmentservice.model.ShipmentLine;
import com.shipment.shipmentservice.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {

  @Autowired private ShipmentRepository shipmentRepository;

  @Autowired private ShipmentLineRepository shipmentLineRepository;

  @Autowired private DeliveryAddressRepository deliveryAddressRepository;
  // find shipment from the database by using method findAll



  public Shipment addShipment(Shipment shipment) {

    DeliveryAddress deliveryAddress = shipment.getDeliveryAddress();
    deliveryAddressRepository.save(deliveryAddress);

    shipmentRepository.save(shipment);

    if (shipment.getShipmentLines().size() > 0) {
        for (ShipmentLine shipmentLine : shipment.getShipmentLines()) {
          shipmentLine.setShipment(shipment);
          shipmentLineRepository.save(shipmentLine);
        }
      }

      return shipment;
  }


  public Shipment getShipmentByShipmentNumber(String shipmentNumber) {
    return shipmentRepository.findByShipmentNumber(shipmentNumber);
  }

  public Shipment updateShipment(String shipmentNumber, Shipment shipment) {
    Shipment existingShipment = shipmentRepository.findByShipmentNumber(shipmentNumber);
    if (existingShipment != null) {
      if (shipment.getShipmentLines().size() > 0) {
        for (ShipmentLine shipmentLine : shipment.getShipmentLines()) {
          ShipmentLine line = shipmentLineRepository.getById(shipmentLine.getId());
          if (line != null) {
            line.setQty(shipmentLine.getQty());
            line.setProduct(shipmentLine.getProduct());
            line.setShipment(existingShipment);
            shipmentLineRepository.save(line);
          }
        }
      }

          DeliveryAddress line = deliveryAddressRepository.getById(existingShipment.getDeliveryAddress().getId());
          if (line != null) {
            line.setStreet(shipment.getDeliveryAddress().getStreet());
            line.setPostCode(shipment.getDeliveryAddress().getPostCode());
            line.setCountry(shipment.getDeliveryAddress().getCountry());
//            line.setShipment(existingShipment);
            deliveryAddressRepository.save(line);
          }



      existingShipment.setEdd(shipment.getEdd());
      existingShipment.setPackaging(shipment.getPackaging());
      existingShipment.setType(shipment.getType());
      return shipmentRepository.save(existingShipment);
    } else {
      return null;
    }
  }

  public void deleteShipmentByNumber(String shipmentNumber) {
    Shipment shipment = shipmentRepository.findByShipmentNumber(shipmentNumber);
    if (shipment != null) {
      if (shipment.getShipmentLines().size() > 0) {
        for (ShipmentLine shipmentLine : shipment.getShipmentLines()) {
          ShipmentLine line = shipmentLineRepository.getById(shipmentLine.getId());
          if (line != null) {
            shipmentLineRepository.deleteById(line.getId());
          }
        }

        DeliveryAddress line = deliveryAddressRepository.getById(shipment.getDeliveryAddress().getId());
        if (line != null) {

          deliveryAddressRepository.deleteById(line.getId());
        }
      }
      shipmentRepository.deleteById(shipment.getId());
        }


  }
}
