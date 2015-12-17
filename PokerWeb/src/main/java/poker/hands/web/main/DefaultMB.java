package poker.hands.web.main;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import poker.hands.service.model.Carta;
import poker.hands.service.model.Mao;
import poker.hands.service.model.Mesa;
import poker.hands.service.util.LanguageUtil;

@SessionScoped
@ManagedBean(name = "defaultMB")
public class DefaultMB implements Serializable {

	private static final long serialVersionUID = 1L;

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
			p1 = mesa.stringToCarta(cards_p1);
		}
		if (p2 == null) {
			p2 = mesa.stringToCarta(cards_p2);
		}
		Mao mao_p1 = new Mao(p1);
		Mao mao_p2 = new Mao(p2);

		short retorno = mao_p1.compareTo(mao_p2);

		switch (retorno) {
		case 0:
			msg = new FacesMessage(
					LanguageUtil.getDescriptionProperties("default.result"),
					LanguageUtil.getDescriptionProperties("default.tie"));
			break;

		case 1:
			msg = new FacesMessage(
					LanguageUtil.getDescriptionProperties("default.result"),
					username_p1
							+ " "
							+ LanguageUtil
									.getDescriptionProperties("default.win")
							+ " " + mao_p1.display());
			break;

		case 2:
			msg = new FacesMessage(
					LanguageUtil.getDescriptionProperties("default.result"),
					username_p2
							+ " "
							+ LanguageUtil
									.getDescriptionProperties("default.win")
							+ " " + mao_p2.display());
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

		// log.debug("OK");

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

	public String getUsername_p1() {
		return username_p1;
	}

	public void setUsername_p1(String username_p1) {
		this.username_p1 = username_p1;
	}

	public String getUsername_p2() {
		return username_p2;
	}

	public void setUsername_p2(String username_p2) {
		this.username_p2 = username_p2;
	}

	public String getCards_p1() {
		return cards_p1;
	}

	public void setCards_p1(String cards_p1) {
		this.cards_p1 = cards_p1;
	}

	public String getCards_p2() {
		return cards_p2;
	}

	public void setCards_p2(String cards_p2) {
		this.cards_p2 = cards_p2;
	}

	public Carta[] getP1() {
		return p1;
	}

	public void setP1(Carta[] p1) {
		this.p1 = p1;
	}

	public Carta[] getP2() {
		return p2;
	}

	public void setP2(Carta[] p2) {
		this.p2 = p2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
