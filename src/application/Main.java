package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Apto;
import model.entities.Hospede;
import model.entities.Reservation;

public class Main {
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);

		// Por se tratar de um projeto did�tico, estamos instanciando todos os aptos vazios.
		// O ideal � chama-los de um banco de dados com suas informa��es salvas.
		Apto[] vectorAptos = new Apto[10];
		for (int i = 0; i < vectorAptos.length; i++)
		{
			vectorAptos[i] = new Apto(i + 1);
		}

		System.out.println("=========================");
		System.out.println("      HOTEL SERVICE      ");
		System.out.println("=========================");

		int option = -1;
		while (option != 0) {
			System.out.println("=========================");
			System.out.println("Quartos disponiveis:");
			for (int i = 0; i < vectorAptos.length; i++) {
				System.out.print("Apto. " + vectorAptos[i].getNumber() + " ");
				if (vectorAptos[i].isAvailable())
					System.out.println("DISPONIVEL");
				else
					System.out.println("OCUPADO");
			}
			System.out.println("=========================");
			System.out.println("1 - Adicionar Hospede");
			System.out.println("2 - Disponibilizar Apto");
			System.out.println("3 - Aptos Ocupados");
			System.out.print("Escolha uma op��o: ");
			option = scanner.nextInt();

			switch (option) {
			case 1:
				System.out.println("\nINSCRI��O");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.print("nome: ");
				scanner.nextLine();
				String name = scanner.nextLine();
				System.out.print("e-mail: ");
				String email = scanner.nextLine();
				System.out.print("Apto numero: ");
				int num = scanner.nextInt();
				System.out.print("chack-In date (dd/MM/yyyy): ");
				Date in = sdf.parse(scanner.next());
				System.out.print("chack-Out date (dd/MM/yyyy): ");
				Date out = sdf.parse(scanner.next());

				Hospede hospede = new Hospede(name, email);
				Reservation reserv = new Reservation(hospede, in, out);
				vectorAptos[num - 1].addReservation(reserv);

				System.out.println("\nINSCRI��O COMPLETA\n");
				break;
			case 2:
				System.out.println("\nDISPONIBILIZAR QUARTO");
				// TODO sistema de disponibiliza��o de quarto
				break;
			case 3:
				System.out.println("\nQUARTOS OCUPADOS");
				// TODO mostrar quartos ocupados e lista de hospedes
			case 0:
				System.out.println("\nGood Bye ;)");
				break;
			default:
				System.out.println("\nInforme uma op��o v�lida!!!\n");
				break;
			}
		}
	}
}
