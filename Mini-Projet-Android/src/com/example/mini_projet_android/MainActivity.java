package com.example.mini_projet_android;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener{
	private Spinner nbrRecherche;
	private Button rechercher;
	private EditText zoneSaisie;
	
	private MainActivity act = this;

	
	
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
	
	
	public void lancerGet(String url){
		AsyncHttpClient client = new AsyncHttpClient();
		client.get(url, new AsyncHttpResponseHandler(){
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2,
					Throwable arg3) {
				Log.e("erreur json",arg3.getMessage());
				
			}

			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				String s = "";
				String jsonData = new String(arg2);
				
				
				try {
					JSONObject repObj = (JSONObject) new JSONTokener(jsonData).nextValue();
					Toast.makeText(act, repObj.getString("nom").toString(), Toast.LENGTH_LONG).show();
					
				} catch (JSONException je) {
					Log.e("TAG", "ERREUR:"+je.getMessage() );
				}
				
			}
			
		});
	}
}
