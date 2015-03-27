package com.example.mini_projet_android;

import java.util.ArrayList;

import org.apache.http.Header;
import org.json.JSONArray;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener, OnItemClickListener{
	private Spinner nbrRecherche;
	private Button rechercher;
	private EditText zoneSaisie;
	private ListView listeTexte;	
	
	private MainActivity act = this;
	ArrayAdapter<String> itemsAdapter;
	ArrayList<String> listeUrl;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		zoneSaisie = (EditText)findViewById(R.id.zoneSaisie);
		
		rechercher = (Button)findViewById(R.id.rechercher);
		rechercher.setOnClickListener(this);
		
		nbrRecherche = (Spinner)findViewById(R.id.nbrRecherche);
		
		listeTexte = (ListView)findViewById(R.id.listeView);
		listeTexte.setOnItemClickListener(this);
		
		
		
	}


	@Override
	public void onClick(View arg0) {
		if(arg0.equals(rechercher)){
			String saisie = zoneSaisie.getText().toString();
			saisie.replace("\\s", "%");
			String url = "https://ajax.googleapis.com/ajax/services/search/images?v=1.0&rsz=" +
					Integer.parseInt(nbrRecherche.getSelectedItem().toString()) +
						"&q="+saisie;
			
			System.out.println(url);
			
			lancerGet(url);
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
			public void onSuccess(int arg0, Header[] arg1, byte[] data) {
				String jsonData = new String(data);
				
				
				try {
					JSONObject repObj = (JSONObject) new JSONTokener(jsonData).nextValue();
					repObj = repObj.getJSONObject("responseData");
					JSONArray tmp = repObj.getJSONArray("results");
	
					listeUrl = new ArrayList<>();							
					for (int i = 0; i < tmp.length(); i++) {
						repObj = (JSONObject) tmp.get(i);
						listeUrl.add(repObj.getString("url"));
					}

					
					itemsAdapter = new ArrayAdapter<String>(act, android.R.layout.simple_list_item_1, listeUrl);
					listeTexte.setAdapter(itemsAdapter);
				} catch (JSONException je) {
					Log.e("TAG", "ERREUR:"+je.getMessage());
				}	
			}
		});
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int numListe, long arg3) {
		Intent intent = new Intent(this, ShowImageActivity.class);
		intent.putExtra(Data.urlImage,listeUrl.get(numListe));
		startActivity(intent);		
	}
}
