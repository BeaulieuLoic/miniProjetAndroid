package com.example.mini_projet_android;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Spinner nbrRecherche;
	private Button rechercher;
	private EditText zoneSaisie;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		zoneSaisie = (EditText)findViewById(R.id.zoneSaisie);
		rechercher = (Button)findViewById(R.id.rechercher);
		nbrRecherche = (Spinner)findViewById(R.id.nbrRecherche);
		
		
		
	}
}
