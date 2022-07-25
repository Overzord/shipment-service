package com.shipment.shipmentservice;

import com.shipment.shipmentservice.dao.DeliveryAddressRepository;
import com.shipment.shipmentservice.dao.ShipmentLineRepository;
import com.shipment.shipmentservice.dao.ShipmentRepository;
import com.shipment.shipmentservice.enums.PackageShipment;
import com.shipment.shipmentservice.enums.TypeShipment;
import com.shipment.shipmentservice.model.DeliveryAddress;
import com.shipment.shipmentservice.model.Shipment;
import com.shipment.shipmentservice.model.ShipmentLine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShipmentServiceApplicationTests {


	@Test
	void contextLoads() {

	}
}
