package com.shipment.shipmentservice.controller;

import com.shipment.shipmentservice.model.Shipment;
import com.shipment.shipmentservice.service.ShipmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
public class ShipmentController {

  private final ShipmentService shipmentService;

  @PostMapping(value = "/shipment", consumes = { MediaType.APPLICATION_JSON_VALUE })
  public ResponseEntity<Shipment> addShipment(@Valid @RequestBody Shipment shipment) {
    Shipment createShipment = shipmentService.addShipment(shipment);
    return new ResponseEntity<>(createShipment, HttpStatus.CREATED);
  }

  @GetMapping("/shipment/{shipmentNumber}")
  public Shipment getShipmentByShipmentNumber(@PathVariable String shipmentNumber) {
    return shipmentService.getShipmentByShipmentNumber(shipmentNumber);
  }

  @PutMapping("/shipment/{shipmentNumber}")
  public Shipment updateShipment(
      @PathVariable String shipmentNumber, @RequestBody Shipment shipment) {
    return shipmentService.updateShipment(shipmentNumber, shipment);
  }

  @DeleteMapping("/shipment/{shipmentNumber}")
  public void deleteShipment(@PathVariable String shipmentNumber) {

    shipmentService.deleteShipmentByNumber(shipmentNumber);
  }
}
