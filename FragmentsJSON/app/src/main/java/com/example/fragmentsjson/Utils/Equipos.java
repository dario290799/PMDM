package com.example.fragmentsjson.Utils;

import com.example.fragmentsjson.MainActivity;

public class Equipos {

    //Atributos
    private int idTeam;
    private String strTeam, strStadium, strTeamBadge;
    //Constructor


    public Equipos(int idTeam, String strTeam, String strStadium, String strTeamBadge) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strTeamBadge = strTeamBadge;
    }
    public Equipos(String strTeam, String strStadium, String strTeamBadge) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
        this.strTeamBadge = strTeamBadge;
    }

    public Equipos(){}

    //Metodos(No hace falta metodo,mediante constructores)

    //Getters & Setters


    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }
}
