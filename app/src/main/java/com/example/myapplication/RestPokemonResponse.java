package com.example.myapplication;

import android.os.IInterface;
import java.util.List;


public class RestPokemonResponse {

    private List<Pokemon> results=null;

    public List<Pokemon> getPokemons(){return results;}
    public void getPokemons(List<Pokemon> pokemons){this.results=pokemons;}
    }

