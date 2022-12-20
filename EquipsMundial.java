/**5.	Es vol fer un programa per obtenir algunes estadístiques d’una lligueta de futbol. (2 punts)
-	El programa, primer demanarà totes les dades: nom dels equips, punts, gols a favor i gols en contra.
-	Després, es mostrarà un menú en el qual es podran fer les següents accions:
o	Consultar tota la taula d’equips, punts, gols a favor i gos en contra.
o	Mostrar l’equip amb més punts
o	Mostra el promig de gols per partit.
o	Mostrar l’equip amb menys gols en contra.
-	Per introduir les dades, es farà mitjançant strings amb valors separats per ; (punt i coma), 
i es desaran en dos arrays: un pels noms dels equips i l’altre  pels punts, gols a favor i gols en contra.
**/
//importem l'Scanner
import java.util.Scanner;

/**
* Programa estadÃ¬stiques mundial
*/
public class EquipsMundial{
	
	/**
	* Punt d'entrada al programa
	*/
	public static void main(String [] args){
		
		//Preparem Scanner
		Scanner sc = new Scanner(System.in);
		//Variables - arrays
		String [] equips;
		int [][] resultats;
		int numEquips = 0;
		//Introdueix equips i fem l'split
		System.out.print("Introdueix els equips: ");
		equips = sc.nextLine().split(";");
		//Per saber quants equips tenim
		numEquips = equips.length;
		//fem trim per treure espais, si hi ha.
		for(int i = 0; i < numEquips; i++){
			equips[i] = equips[i].trim();
		}
		
		//Introdueix punts. Necessitem arrays temporals de tipus string
		System.out.print("Introdueix els punts: ");
		String [] strPunts = sc.nextLine().split(";");
		//Introdueix gols a favor
		System.out.print("Introdueix els gols a favor: ");
		String [] strGF = sc.nextLine().split(";");
		//Introdueix gols en contra
		System.out.print("Introdueix els gols en contra: ");
		String [] strGC = sc.nextLine().split(";");
		
		
		//ara passem els valors enters amb el parseInt. TambÃ© definim la matriu de resultats
		resultats = new int[numEquips][3];
		//No fem tractament d'errors. Considerem l'usuari prou llest per posar els valors que toquen
		for(int i = 0; i < numEquips; i++){
			//Abans hem de fer trim per no deixar espais en blanc que donarien error.
			//punts
			resultats[i][0] = Integer.parseInt(strPunts[i].trim());
			//GF
			resultats[i][1] = Integer.parseInt(strGF[i].trim());
			//GC
			resultats[i][2] = Integer.parseInt(strGC[i].trim());
			
		}
		//Ja tenim la matriu de resultats plena.
		//Mostrem menu d'opcions
		boolean sortir = false;
		do{
			System.out.println(" *** Partits mundial *** ");
			System.out.println("   1)Mostrar taula");
			System.out.println("   2)Equip amb mes punts");
			System.out.println("   3)Promig de gols");
			System.out.println("   4)Equip amb menys gols en contra");
			System.out.println("   5)Sortir");
			int opcio = sc.nextInt();
			//Nateja buffer
			sc.nextLine();
			//variables
			double promig = 0;
			int indexEquip = 0;
			switch(opcio){
				case 1:
						System.out.println("Equips\t\tPunts\tGF\tGC");
						for(int i = 0; i < numEquips; i++){
							System.out.print(equips[i] + "\t\t");
							System.out.print(resultats[i][0] + "\t");
							System.out.print(resultats[i][1] + "\t");
							System.out.print(resultats[i][2]);
							System.out.println();
							
						}
						
						break;
				case 2:
						//Equips amb mes punts. Assignem el primer i comparem amb la resta
						// el primer serà  indexEquip = 0
						indexEquip = 0;
						for(int i = 1; i < numEquips; i++){
							//Te mÃ©s punts?
							if(resultats[indexEquip][0] < resultats[i][0]){
								indexEquip = i;
							}
						}
						//Mostrem
						System.out.println("\nEquip amb mes punts: " + equips[indexEquip] + " punts -> " + resultats[indexEquip][0]);
						break;
				case 3:
						//Promig de gols
						promig = 0;
						for(int i = 0; i < numEquips; i++){
							promig += resultats[i][1];
						}
						promig = promig / numEquips;
						System.out.println("\nPromig de gols: " + promig);
						break;
				case 4:
						//Igual que punts pero cerquem el minim a la 2a columna
						indexEquip = 0;
						for(int i = 1; i < numEquips; i++){
							//Te mÃ©s punts?
							if(resultats[indexEquip][2] > resultats[i][2]){
								indexEquip = i;
							}
						}
						//Mostrem
						System.out.println("\nEquip amb menys gols en contra: " + equips[indexEquip] + " GC -> " + resultats[indexEquip][2]);
						
						
						break;
				case 5:
						sortir = true;
						break;
				default:
						System.out.println("Opcio no valida!");
			}
		System.out.println();	
		}while(!sortir);
		
		
		
		
	}
	
}
