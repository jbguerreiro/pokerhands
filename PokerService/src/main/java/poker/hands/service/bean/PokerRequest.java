package poker.hands.service.bean;

import javax.ws.rs.FormParam;

import lombok.Data;


public class PokerRequest {

	@FormParam("name_p1")
	private String name_p1;

	@FormParam("name_p2")
	private String name_p2;

	@FormParam("cartas_p1")
	private String cartas_p1;

	@FormParam("cartas_p2")
	private String cartas_p2;

	public String getName_p1() {
		return name_p1;
	}

	public void setName_p1(String name_p1) {
		this.name_p1 = name_p1;
	}

	public String getName_p2() {
		return name_p2;
	}

	public void setName_p2(String name_p2) {
		this.name_p2 = name_p2;
	}

	public String getCartas_p1() {
		return cartas_p1;
	}

	public void setCartas_p1(String cartas_p1) {
		this.cartas_p1 = cartas_p1;
	}

	public String getCartas_p2() {
		return cartas_p2;
	}

	public void setCartas_p2(String cartas_p2) {
		this.cartas_p2 = cartas_p2;
	}

}
