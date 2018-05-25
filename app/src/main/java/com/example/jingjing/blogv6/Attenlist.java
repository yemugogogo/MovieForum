package com.example.jingjing.blogv6;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Attenlist extends ArrayAdapter<Attention> {
    FirebaseFirestore db= FirebaseFirestore.getInstance();

    private Activity context;
    private List<Attention> Attentions;

    public Attenlist(Activity context,List<Attention> Attention){
        super(context,R.layout.listview_myatten, Attention);
        this.context=context;
        this.Attentions = Attention;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listviewItem=inflater.inflate(R.layout.listview_myatten,null,true);
        TextView attenname=(TextView)listviewItem.findViewById(R.id.attenname);
        Attention Attention = Attentions.get(position);
        //Article Article = Articles.get(position);
        Log.e("ooo", " Found - |" + Attention.getBlgger_name() + "|");
        attenname.setText(Attention.getBlgger_name());


        return listviewItem;
    }
}
