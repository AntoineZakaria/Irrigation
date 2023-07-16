package com.digitalfactory.Irrigation;

import com.digitalfactory.Irrigation.dto.request.CreatePlotRequest;
import com.digitalfactory.Irrigation.entity.PlotTimeslot;
import com.digitalfactory.Irrigation.repo.IrrigationTimeSlotRepo;
import com.digitalfactory.Irrigation.repo.PlotRepo;
import com.digitalfactory.Irrigation.repo.PlotTimeSlotRepo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IrrigationApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	PlotRepo plotRepo ;

	@Autowired
	PlotTimeSlotRepo plotTimeSlotRepo ;

	@Autowired
	IrrigationTimeSlotRepo timeSlotRepo ;






	String URL ="";


	@BeforeEach
	public void setUp() {
		RestAssured.port = port;

		URL = "http://localhost";
		URL = URL.concat(":").concat(port + "").concat("/v1/plot");

		plotTimeSlotRepo.deleteAll();
		plotRepo.deleteAll();
		timeSlotRepo.deleteAll();
	}


	@Test
	public void testCreatePlotSuccess() {
		CreatePlotRequest createPlotRequest = CreatePlotRequest.builder()
				.area(50.0).build();
		Response response = RestAssured.given()
                .contentType("application/json")
                .body(createPlotRequest)
                .post(URL);
		assertEquals(201, response.getStatusCode());
	}

	@Test
	public void testCreatePlotFail() {
		CreatePlotRequest createPlotRequest = CreatePlotRequest.builder()
				.build();
		Response response = RestAssured.given()
				.contentType("application/json")
				.body(createPlotRequest)
				.post(URL);
		assertEquals(400, response.getStatusCode());
	}

	//TODO continnue tests
}