package com.example.fragmentsjson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fragmentsjson.Utils.Equipos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*String url="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
        JsonObjectRequest peticionJson = new JsonObjectRequest(1, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.v("peticion","peticion correcta");
                procesarPeticion(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.v("peticion","peticion incorrecta");
            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(peticionJson);*/
    }

    private void procesarPeticion(JSONObject response) {

        try {
            JSONArray arrayResultado = response.getJSONArray("teams");
            for (int i = 0; i < arrayResultado.length(); i++){
                JSONObject equipo = arrayResultado.getJSONObject(i);
                String nombre = equipo.getString("strTeam");
                String estadio = equipo.getString("strStadium");
                String escudo = equipo.getString("strTeamBadge");
                int idEquipo = equipo.getInt("idTeam");

                Equipos equipos = new Equipos(nombre,estadio,escudo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}