package application;

import java.util.Locale;
import java.util.Scanner;
import entities.Hospede;

public class Main
{
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Hospede[] quartos = new Hospede[10];
		int option = 10;

		System.out.println("=========================");
		System.out.println("Bem vindo ao HOTEL TARUGO");
		System.out.println("=========================");
		System.out.print("\n");

		while (option != 0)
		{
			Screen.quartosDisponiveis(quartos);
			System.out.println("\n=========================\n");
			option = Screen.mainMenu(scanner);

			switch (option)
				{
				case 1:
					System.out.printf("\n");
					Hospede host = Screen.inscricao(scanner);

					if (host != null)
					{
						if (quartos[host.getNumQuarto() - 1] == null)
						{
							quartos[host.getNumQuarto() - 1] = host;
							System.out.println("\nCADASTRO EFETUADO COM SUCESSO!\n");
						} else
						{
							System.out.println("\nAPTO OCUPADO!!!\n");
						}
					} else
					{
						System.out.println("Ops! algo deu errado com o cadastro!");
					}
					break;
				case 2:
					System.out.printf("\n");
					byte apto = (byte)(Screen.retirarHospede(scanner) - 1);
					
					if (quartos[apto] != null) {
						quartos[apto] = null;
						System.out.println("\nQUARTO " + (apto + 1) + " DISPONIBILIZADO COM SUCESSO\n");
					} else {
						System.out.println("\nO APTO " + apto + " JA SE ENCONTRA DISPONIVEL\n");
					}
					break;
				case 0:
					break;
				default:
					System.out.println("\nInforme uma opção válida!!!\n");
					break;
				}
		}
		System.out.println("\nGood Bye ;)");
	}
}
