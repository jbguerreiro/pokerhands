package poker.hands.service.bean;

import javax.ws.rs.FormParam;

import lombok.Data;

@Data
public class PokerRequest {

	@FormParam("name_p1")
	private String name_p1;

	@FormParam("name_p2")
	private String name_p2;

	@FormParam("cartas_p1")
	private String cartas_p1;

	@FormParam("cartas_p2")
	private String cartas_p2;

}
