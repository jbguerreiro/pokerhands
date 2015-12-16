package poker.hands.service.model;

public class Main {

	public static void main(String[] args) {

		Mesa mesa = new Mesa();

		Carta carta;

		System.out.println(mesa.getTotalCartas());

		while (mesa.getTotalCartas() != 0) {

			carta = mesa.removerDaMesa();

			System.out.println(carta.toString());

		}

	}
}