package com.michell.demo07_michell_2;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MICHELL on 27/05/2017.
 */

public class LVMainAdapter extends ArrayAdapter<Persona> {
    public LVMainAdapter(Context context) {
        super(context, 0, new ArrayList<Persona>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);

        TextView tvMainFullname, tvMainDocument, tvMainAge;

        tvMainFullname = (TextView) convertView.findViewById(R.id.tvMainFullname);
        tvMainDocument = (TextView) convertView.findViewById(R.id.tvMainDocument);
        tvMainAge = (TextView) convertView.findViewById(R.id.tvMainAge);

        Persona persona = getItem(position);

        tvMainFullname.setText(persona.getNombre() + ' '+persona.getApellido());
        tvMainDocument.setText(persona.getDni());
        tvMainAge.setText(String.valueOf(persona.getEdad()));

        return convertView;
    }
}
