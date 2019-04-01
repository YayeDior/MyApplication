package com.example.myapplication;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Pokemon> values;
    Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView img;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = v.findViewById(R.id.header);
            txtFooter = v.findViewById(R.id.footer);
            img = v.findViewById(R.id.icon);
        }
    }


    // Return the size of your dadaist (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

    public void  remove(int position ){
        values.remove( position );
        notifyItemInserted(position);
    }

    public void add(int position, Pokemon item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public MyAdapter(List<Pokemon> values, Context context){
        this.values = values;
        this.context=context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, padding and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dadaist at this position
        // - replace the contents of the view with that element
        final Pokemon pokemon = values.get(position);
        String icon = pokemon.getName();

      final  int iconId =context.getResources().getIdentifier(icon,"drawable",context.getPackageName());

        holder.img.setImageResource(iconId);
      holder.txtHeader.setText(pokemon.getName());

        holder.txtFooter.setText("Footer: " + pokemon.getName());
    }


}
