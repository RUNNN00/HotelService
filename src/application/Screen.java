package application;

import java.util.Scanner;
import entities.Hospede;

public class Screen
{
	public static void quartosDisponiveis(Hospede[] quartos)
	{
		System.out.println("=========================");
		System.out.println("Quartos disponiveis:");

		for (int i = 0; i < quartos.length; i++)
		{
			System.out.printf("Apto. %2d", i + 1);

			if (quartos[i] != null)
				System.out.println(" => OCUPADO POR " + quartos[i].getNome());
			else
				System.out.println(" => DISPONIVEL");
		}
		System.out.println("=========================");
	}

	public static byte mainMenu(Scanner scan)
	{
		System.out.println("Selecione a opção que deseja fazer:");
		System.out.println("1 > Adicionar Hospede");
		System.out.println("2 > Retirar Hospede");
		System.out.println("0 > Encerrar");
		return scan.nextByte();
	}

	public static Hospede inscricao(Scanner scan)
	{
		System.out.println("INSCRIÇÃO");
		System.out.printf("nome: ");
		scan.nextLine();
		String nome = scan.nextLine();
		System.out.printf("E-mail: ");
		String email = scan.nextLine();
		System.out.printf("numero do Apto: ");
		byte apto = scan.nextByte();

		if (apto > 10 || apto < 1)
		{
			System.out.println("\nApto inexistente!!!\n");
			return null;
		}

		return new Hospede(nome, email, apto);
	}

	public static byte retirarHospede(Scanner scan)
	{
		System.out.println("DISPONIBILIZAR APTO");
		System.out.println("Qual Apto. deseja disponibilizar:");
		byte apto = scan.nextByte();

		if (apto > 10 || apto < 1)
		{
			System.out.println("\nApto inexistente!!!\n");
			return 0;
		}

		return apto;
	}
}
