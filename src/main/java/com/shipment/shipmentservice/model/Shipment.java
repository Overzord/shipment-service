package com.shipment.shipmentservice.model;
// We’re going to create a simple Shipment service that manages the Shipment of a company.
// We’ll store shipment objects in a (sql) database,
// and access them (via something called JPA).
// Then we’ll wrap that with something that will allow access over the internet (web: spring MVC)

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.shipment.shipmentservice.enums.PackageShipment;
import com.shipment.shipmentservice.enums.TypeShipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Shipment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Pattern(regexp = "^\\d{8}", message = "shipmentNumber must be a number and must be equals to 8")
  @NotBlank(message = "the shipment Number is required")
  @Column(unique = true)
  private String shipmentNumber;

  @JsonManagedReference
  @OneToMany(mappedBy = "shipment")
  @Valid
  private List<ShipmentLine> shipmentLines;


  @Enumerated(EnumType.STRING)
  private PackageShipment packaging;

  @OneToOne
  @JoinColumn(name = "delivery_address_id", referencedColumnName = "id")
  @Valid
  private DeliveryAddress deliveryAddress;

  @Enumerated(EnumType.STRING)
  private TypeShipment type;

  private String edd;


}
