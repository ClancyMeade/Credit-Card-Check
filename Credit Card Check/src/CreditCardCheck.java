import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditCardCheck
	{

		public static void main(String[] args) throws FileNotFoundException
			{

				Scanner file = new Scanner(new File("CreditCards.txt"));

				int counter = 0;

				while (file.hasNext())
					{

						long creditCardNumber = Long.parseLong(file.nextLine());

						long[] individualNumbersInCardArray = new long[16];

						for (int i = 15; i >= 0; i--)
							{
								individualNumbersInCardArray[i] = creditCardNumber % 10;
								creditCardNumber /= 10;
							}

						for (int i = 0; i < 16; i += 2)
							{

								long doubledNumber = individualNumbersInCardArray[i] * 2;

								if (doubledNumber > 9)
									{

										long[] digitsToBeSummed = new long[2];

										digitsToBeSummed[0] = doubledNumber % 10;
										digitsToBeSummed[1] = doubledNumber / 10;

										long summedNumbers = digitsToBeSummed[0] + digitsToBeSummed[1];

										individualNumbersInCardArray[i] = summedNumbers;

									}

								else
									{
										individualNumbersInCardArray[i] = individualNumbersInCardArray[i] * 2;
									}
							}

						int sum = 0;

						for (int i = 0; i < individualNumbersInCardArray.length; i++)
							{
								sum += individualNumbersInCardArray[i];
							}

						if (sum % 10 == 0)
							{
								counter++;
							}

					}
				System.out.println("There are " + counter + " vaid credit cards.");
			}

	}
