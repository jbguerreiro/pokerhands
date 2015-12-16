package poker.hands.service.model;

public class Carta {

	private short valor, naipe;

	private static String[] naipes = { "P", "C", "O", "E" };

	private static String[] valores = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	public static String valorAsString(int valor) {

		return valores[valor];
	}

	Carta(short naipe, short valor) {

		this.valor = valor;

		this.naipe = naipe;

	}

	@Override
	public String toString() {

		return valores[valor] + naipes[naipe];

	}

	public short getValor() {

		return valor;

	}

	public short getNaipe() {

		return naipe;

	}

}
