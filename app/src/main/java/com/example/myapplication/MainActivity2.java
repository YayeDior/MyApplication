package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private PokemonResApi pokemonRestApi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity2_main );


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl( "https://pokeapi.co/api/v2/" )
                .addConverterFactory( GsonConverterFactory.create( gson ) )
                .build();
        pokemonRestApi = retrofit.create( PokemonResApi.class );

        Call<RestPokemonResponse> call = pokemonRestApi.getListPokemons();
        call.enqueue( new Callback<RestPokemonResponse>() {
            @Override
            public void onResponse(Call<RestPokemonResponse> call, Response<RestPokemonResponse> response) {
                RestPokemonResponse restPokemonResponse = response.body();
                List<Pokemon> ListPokemon = restPokemonResponse.getPokemons();

                showList(ListPokemon);
            }

            @Override
            public void onFailure(Call<RestPokemonResponse> call, Throwable t) {
                Log.d( "Oui", "API OK" );

            }
        } );


    }

    private void showList(List<Pokemon> listPokemon) {

        recyclerView = findViewById(R.id.my_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter=new MyAdapter( listPokemon,getApplicationContext());
        recyclerView.setAdapter(mAdapter);

    }


}

