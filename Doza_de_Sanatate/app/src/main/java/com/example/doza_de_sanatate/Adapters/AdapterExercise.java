package com.example.doza_de_sanatate.Adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.doza_de_sanatate.RoomDataBase.Classes.Antrenament;
import com.example.doza_de_sanatate.RoomDataBase.Classes.Exercitiu;
import com.example.doza_de_sanatate.R;

import java.util.List;

public class AdapterExercise extends ArrayAdapter<Exercitiu> {

    private Context myContext;
    private int resourceID;
    private LayoutInflater inflater;
    private String gen;

    static class ViewHolder{
        private ImageView adapterExerciceImageView;
        private TextView adapterExerciceTextView;
        private ConstraintLayout adapterExerciceLayout;
    }

    public AdapterExercise(@NonNull Context context, int resource, @NonNull List<Exercitiu> objects, LayoutInflater inflater, String gen) {
        super(context, resource, objects);
        this.myContext = context;
        this.resourceID = resource;
        this.inflater = inflater;
        this.gen = gen;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = inflater.inflate(resourceID, parent, false);

        ViewHolder holder = new ViewHolder();
        holder.adapterExerciceImageView = (ImageView) convertView.findViewById(R.id.adapter_exercice_image);
        holder.adapterExerciceTextView = (TextView) convertView.findViewById(R.id.adapter_exercice_name);
        holder.adapterExerciceLayout = (ConstraintLayout) convertView.findViewById(R.id.adapter_exercice_layout);
        convertView.setTag(holder);

        int pozaGasita=0;

        if(getItem(position) != null){
            holder.adapterExerciceTextView.setText(getItem(position).getDenumireExercitiuID().toString());
             if(this.gen.equals("Barbat") ){
                 if(!getItem(position).getIconitaBarbat().equals("")){
                     pozaGasita = myContext.getResources().getIdentifier(getItem(position).getIconitaBarbat(), "drawable", myContext.getPackageName());
                 }else{
                      pozaGasita = myContext.getResources().getIdentifier(getItem(position).getIconitaFemeie(), "drawable", myContext.getPackageName());
                 }
             }
             else if(this.gen.equals("Femeie")){
                 holder.adapterExerciceLayout.setBackgroundColor(Color.WHITE);
                 holder.adapterExerciceTextView.setTextColor(Color.BLACK);
                 if(!getItem(position).getIconitaFemeie().equals("")){
                     pozaGasita = myContext.getResources().getIdentifier(getItem(position).getIconitaFemeie(), "drawable", myContext.getPackageName());
                 }else{
                     pozaGasita = myContext.getResources().getIdentifier(getItem(position).getIconitaBarbat(), "drawable", myContext.getPackageName());
                 }
             }
            holder.adapterExerciceImageView.setImageResource(pozaGasita);
        }

        else{
            holder.adapterExerciceTextView.setVisibility(View.INVISIBLE);
            holder.adapterExerciceImageView.setVisibility(View.INVISIBLE);
        }

        return convertView;
    }

}
