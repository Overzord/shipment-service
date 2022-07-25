package com.shipment.shipmentservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipmentLine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "product is required")
  private String product;

  @NotBlank(message = "qty is required")
  private String qty;
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "shipment_id")
  private Shipment shipment;
}
