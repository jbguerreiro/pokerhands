package poker.hands.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import poker.hands.service.bean.PokerRequest;
import poker.hands.service.bean.PokerResponse;

@Component
@Path("/{poker:[pP][oO][kK][eE][rR]}")
@Log4j
public class PokerWebService {

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/{start:[sS][tT][aA][rR][tT]}")
	public PokerResponse startGame(PokerRequest pokerRequest, @Context HttpServletRequest req)
			throws UnsupportedEncodingException {
		PokerResponse pokerResponse = new PokerResponse();

		pokerResponse.setMainMessage(pokerRequest.getCartas_p1());
		log.info("Em desenvolvimento");
		return pokerResponse;
	}
}
