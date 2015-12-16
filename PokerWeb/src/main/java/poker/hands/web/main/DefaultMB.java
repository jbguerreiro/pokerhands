package poker.hands.web.main;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import lombok.Data;
import lombok.extern.log4j.Log4j;
import poker.hands.service.model.Carta;
import poker.hands.service.model.Mao;
import poker.hands.service.model.Mesa;
import poker.hands.service.util.LanguageUtil;

@SessionScoped
@ManagedBean(name = "defaultMB")
@Log4j
@Data
public class DefaultMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<Short, Short> map_p1;
	private Map<Short, Short> map_p2;

	private String username_p1;
	private String username_p2;

	private String cards_p1;
	private String cards_p2;

	private Carta[] p1;
	private Carta[] p2;

	public String startGame() {

		FacesMessage msg = new FacesMessage();
		Mesa mesa = new Mesa();

		if (p1 == null) {
			p1 = mesa.procuraDaMesa(cards_p1);
		}
		if (p2 == null) {
			p2 = mesa.procuraDaMesa(cards_p2);
		}
		Mao mao_p1 = new Mao(p1);
		Mao mao_p2 = new Mao(p2);

		//
		// mao_p1.display();
		//
		// mao_p1.displayAll();
		//
		// mao_p2.display();
		//
		// mao_p2.displayAll();

		short retorno = mao_p1.compareTo(mao_p2);

		switch (retorno) {
		case 0:
			msg = new FacesMessage(LanguageUtil.getDescriptionProperties("default.result"),
					LanguageUtil.getDescriptionProperties("default.tie"));
			break;

		case 1:
			msg = new FacesMessage(LanguageUtil.getDescriptionProperties("default.result"),
					username_p1 + " " + LanguageUtil.getDescriptionProperties("default.win") + " " + mao_p1.display());
			break;

		case 2:
			msg = new FacesMessage(LanguageUtil.getDescriptionProperties("default.result"),
					username_p2 + " " + LanguageUtil.getDescriptionProperties("default.win") + " " + mao_p2.display());
			break;

		}
		p1 = null;
		p2 = null;
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return "main";
	}

	public String generateCards() {

		Mesa mesa = new Mesa();

		p1 = getFiveCards(mesa);
		p2 = getFiveCards(mesa);

		cards_p1 = StringUtils.join(p1, " ");
		cards_p2 = StringUtils.join(p2, " ");

		log.debug("OK");

		return "main";
	}

	private Carta[] getFiveCards(Mesa mesa) {
		Carta carta;
		Carta[] cartas = new Carta[5];
		short count = 0;

		while (count < 5) {
			carta = mesa.removerDaMesa();
			cartas[count] = carta;

			count++;
		}
		return cartas;

	}

	private void nula() {

	}

}
