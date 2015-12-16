package poker.hands.service.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Mesa {

	private ArrayList<Carta> cartas;

	public Mesa() {

		cartas = new ArrayList<Carta>();

		int index_1, index_2;

		Random generator = new Random();

		Carta temp;

		for (short naipe = 0; naipe <= 3; naipe++) {
			for (short valor = 0; valor <= 12; valor++) {
				cartas.add(new Carta(naipe, valor));
			}

		}

		int size = cartas.size() - 1;

		for (short i = 0; i < 100; i++) {

			index_1 = generator.nextInt(size);

			index_2 = generator.nextInt(size);

			temp = (Carta) cartas.get(index_2);

			cartas.set(index_2, cartas.get(index_1));

			cartas.set(index_1, temp);

		}

	}

	public Carta removerDaMesa() {

		return cartas.remove(cartas.size() - 1);

	}

	public Carta[] procuraDaMesa(String cartasMao) {

		String[] cartaMao = cartasMao.split(" ");
		Carta[] cartaRetorno = new Carta[5];

		for (int i = 0; i < cartaMao.length; i++) {
			for (Iterator<Carta> iterator = cartas.iterator(); iterator.hasNext();) {
				Carta carta = (Carta) iterator.next();

				if (carta.toString().equals(cartaMao[i])) {
					cartaRetorno[i] = carta;
				}
			}
		}

		return cartaRetorno;

	}

	public int getTotalCartas() {

		return cartas.size();

	}

}
