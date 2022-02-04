package com.example.examendario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerDario;
    private NavigationView menu_desplegable;
    private ListView listaSports;
    private ArrayList arraySports;


 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();


    }
    private void instancias() {
        drawerDario = (DrawerLayout) findViewById(R.id.drawerdario);
        menu_desplegable = (NavigationView) findViewById(R.id.menu_desplegable);
        listaSports = (ListView)  findViewById(R.id.listaSports);

    }

    /*private void rellenarLista() throws IOException, JSONException {
        JSONArray array = realizarPeticion();
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            arraySports.add(object.getString("question"));
        };
    }
    public static JSONArray realizarPeticion() throws IOException, JSONException {
        JSONArray array = null;

        String url = "https://opentdb.com/api.php?amount=10&category=15&type=boolean";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());
        JSONObject myResponse = new JSONObject(response.toString());
        array = myResponse.getJSONArray("results");
        return array;
    }**/

}