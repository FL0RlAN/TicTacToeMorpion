package com.example.andro_morpion;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {


	//On crée un joueur courant  pour savoir qui a appuyé sur le bouton
	private String PlayerCurr="J1";
	
	// On crée un tableau de Strings, 
	// de sorte à s'en servir de tableau de donnée pour le jeu
	private String[] tableStrings = new String[]{"-","-",
			"-","-","-","-","-","-","-"};

	// Fonction pour remplir l'ArrayList avec le tableau de Strings
    private void RemplirListe() {
		 
    	//table.clear();
		
    	for (int i=0; i<tableStrings.length; i++) {
    		//table.add(tableStrings[i]);
    		if(i==0){
    			final Button buttonL1C1 = (Button) findViewById(R.id.buttonC1L1);
    			buttonL1C1.setText(tableStrings[0]);
    		}
    		if(i==1){
    			final Button buttonL1C2 = (Button) findViewById(R.id.buttonL1C2);
    			buttonL1C2.setText(tableStrings[1]);
    		}
    		if(i==2){
    			final Button buttonL1C3 = (Button) findViewById(R.id.buttonL1C3);
    			buttonL1C3.setText(tableStrings[2]);
    		}
    		if(i==3){
    			final Button buttonL2C1 = (Button) findViewById(R.id.buttonL2C1);
    			buttonL2C1.setText(tableStrings[3]);
    		}
    		if(i==4){
    			final Button buttonL2C2 = (Button) findViewById(R.id.buttonL2C2);
    			buttonL2C2.setText(tableStrings[4]);
    		}
    		if(i==5){
    			final Button buttonL2C3 = (Button) findViewById(R.id.buttonL2C3);
    			buttonL2C3.setText(tableStrings[5]);
    		}
    		if(i==6){
    			final Button buttonL3C1 = (Button) findViewById(R.id.buttonL3C1);
    			buttonL3C1.setText(tableStrings[6]);
    		}
    		if(i==7){
    			final Button buttonL3C2 = (Button) findViewById(R.id.buttonL3C2);
    			buttonL3C2.setText(tableStrings[7]);
    		}
    		if(i==8){
    			final Button buttonL3C3 = (Button) findViewById(R.id.buttonL3C3);
    			buttonL3C3.setText(tableStrings[8]);
    		}
    	}
    }
    
	// Fonction pour tester si le joueur à gagné
    private void GagneOuPas(String Joueur) {
    	String key;
    	int verif=0;
    	if(Joueur.equals("J1")) key="X";
    	else key="O";
    	
    	//test L1 et L2 et L3
    	for(int i=0;i<8;i++) {
    		// si on a la bonne key
    		if ( tableStrings[i].equals(key)){
    			verif++;
    			//-----------------------------------------------------------------------------------------------------------------------------------------
    			//tableStrings[i]="g"; ERRRRRRRRRRRRRRREEEEEEEEEEEEEEEUUUUUUUUUUUUUURRRRRRRR ICCCCCCCCCCCCCCCCCCCCCCCCCCCCCIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
    			//----------------------------------------------------------------------------------------------------------------------------------------------
    			// si verif = 3 alors on a 3 fois la key donc on a gagné
        		if(verif==3){
        			 final TextView PlayerC = (TextView) findViewById(R.id.whoWin);
            		 PlayerC.setText("Joueur "+Joueur+"a gagné");
        		}
    		}
    		// si on a pas gagné la ligne on remet le verif à zero
    		if(i==2 || i==5) verif=0; 
    	}
    	verif=0;
    	//-----------------ereuuuuuuuuuuuuuurrrrrrrrrrrrrrrr
    	//-------------------------------------------------------
    	//test C1 et C2 et C3
    	for(int u=0;u<3;u++) {
    		for(int i=0;i<3;i++) {
    		// si on a la bonne key
    		if ( tableStrings[i].equals(key)){
    			verif++;
    			// si verif = 3 alors on a 3 fois la key donc on a gagné
        		if(verif==3){
        			 final TextView PlayerC = (TextView) findViewById(R.id.whoWin);
            		 PlayerC.setText("Joueur "+Joueur+"a gagné");
        		}
    		}
    		// si on a pas gagné la ligne on remet le verif à zero
    		if(i==2 || i==5) verif=0; 
    		}
    	}
    	
    }
    	
    
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		RemplirListe();

		final Button buttonL1C1 = (Button) findViewById(R.id.buttonC1L1);
        buttonL1C1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[0]="X";   
            		 GagneOuPas("J1");
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            		
            	 }else {
            		 tableStrings[0]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL1C2 = (Button) findViewById(R.id.buttonL1C2);
        buttonL1C2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[1]="X";    
            		 GagneOuPas("J1");
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[1]="O";  
            		 GagneOuPas("J2");
            		 PlayerCurr="J1";
            		 
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            	
            }
        });
        final Button buttonL1C3 = (Button) findViewById(R.id.buttonL1C3);
        buttonL1C3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[2]="X";   
            		 GagneOuPas("J1");
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[2]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL2C1 = (Button) findViewById(R.id.buttonL2C1);
        buttonL2C1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[3]="X";  
            		 GagneOuPas("J1");
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[3]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL2C2 = (Button) findViewById(R.id.buttonL2C2);
        buttonL2C2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[4]="X";            		 
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[4]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL2C3 = (Button) findViewById(R.id.buttonL2C3);
        buttonL2C3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[5]="X";            		 
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[5]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL3C1 = (Button) findViewById(R.id.buttonL3C1);
        buttonL3C1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[6]="X";            		 
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[6]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL3C2 = (Button) findViewById(R.id.buttonL3C2);
        buttonL3C2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[7]="X";            		 
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[7]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonL3C3 = (Button) findViewById(R.id.buttonL3C3);
        buttonL3C3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	 if (PlayerCurr.equals("J1")) {
            		 tableStrings[8]="X";            		 
            		 PlayerCurr="J2";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 2 à vous de jouer ");
            	 }else {
            		 tableStrings[8]="O";            		 
            		 PlayerCurr="J1";
            		 final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
            		 PlayerC.setText("Joueur 1 à vous de jouer ");
            	 }
            	RemplirListe();
            }
        });
        final Button buttonRePlay = (Button) findViewById(R.id.buttonReplay);
        buttonRePlay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
            	final TextView PlayerC = (TextView) findViewById(R.id.whoPlay);
       		    PlayerC.setText(" ");
       		    final TextView PlayerW = (TextView) findViewById(R.id.whoWin);
    		    PlayerW.setText(" ");
            	for(int i=0;i<tableStrings.length;i++){
            		tableStrings[i]="-";
            	}
            	RemplirListe();
            }
        });
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/* pour agrandir le gridview
	 * http://stackoverflow.com/questions/13881960/how-to-change-items-layout-in-the-grid-view-in-code
	 *
	 *
	 *pour gerer les fgridview
	 *http://developer.android.com/guide/topics/ui/layout/gridview.html
	 *
	 */
	

}
