package com.example.mini_projet_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class MainActivity extends Activity implements OnClickListener{
	private Spinner nbrRecherche;
	private Button rechercher;
	private EditText zoneSaisie;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		zoneSaisie = (EditText)findViewById(R.id.zoneSaisie);
		
		rechercher = (Button)findViewById(R.id.rechercher);
		rechercher.setOnClickListener(this);
		
		nbrRecherche = (Spinner)findViewById(R.id.nbrRecherche);
		
		
		
	}


	@Override
	public void onClick(View arg0) {
		if(arg0.equals(rechercher)){

		}		
	}
}
