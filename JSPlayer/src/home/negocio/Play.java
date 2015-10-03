package home.negocio;

import java.util.Scanner;

public class Play {

	public Play(){
	  int w = 0;
	  CustomPlayer player = new CustomPlayer();
	  String musica = null;
	  
	  Scanner sc = new Scanner(System.in);
	  String faixa = sc.nextLine();
	  switch(faixa){
	  case "1":
	   musica = ("res/Imagine Dragons - Radioactive.mp3");
	   System.out.print(musica.substring(4) + " Tocando!");
	   break;
	  case "2":
	   musica = ("res/O Rappa - Pescador de Ilusões.mp3");
	   System.out.print(musica.substring(4) + " Tocando!");	
	   break;
	  case "3":
	   musica = ("res/Onime - Tenro (Sprtn Remix).mp3");
	   System.out.print(musica.substring(4) + " Tocando!");
	   break;
	  case "4":
	   
	   musica = ("res/Phil Collins - Another Day In Paradise.mp3");
	   System.out.print(musica.substring(4) + " Tocando!");
	   break;
	  case "5":
	   musica = ("res/Above & Beyond - Counting Down The Days.mp3");
	   System.out.print(musica.substring(4) + " Tocando!");
	   break;
	  default:
	   break;
	  }
	  player.setPath(musica);
	  player.play(-1);
	  
	  
	  while (w == 0) {
	   
	   
	   
	   String controle = sc.nextLine();
	   if (controle.equals("P") || controle.equals("p")) {
	    player.pause();
	    System.out.println("Música Pausada!");
	   } else if (controle.equals("R") || controle.equals("r")) {
	    player.resume();
	    System.out.println("Música Tocando!");

	   } else if (controle.equals("S") || controle.equals("s")) {
	    player.pause();
	    player = null;
	    System.out.println("Música Encerrada!");
	    w++;
	   }

	  }
	 }

}
