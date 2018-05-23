package com.example.jingjing.blogv6;

import android.app.Activity;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class Bloglist_myblog extends ArrayAdapter<myblog> {

    FirebaseFirestore db= FirebaseFirestore.getInstance();

    private Activity context;
    private List<myblog> myblogs;

    public Bloglist_myblog(Activity context,List<myblog> myblogs){
        super(context,R.layout.listview_myblog,myblogs);
        this.context=context;
        this.myblogs=myblogs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View listviewItem=inflater.inflate(R.layout.listview_myblog,null,true);
        TextView myblog_1=(TextView)listviewItem.findViewById(R.id.myblog_1);
        TextView myblog_2=(TextView)listviewItem.findViewById(R.id.myblog_2);
        TextView myblog_3=(TextView)listviewItem.findViewById(R.id.myblog_3);
        TextView myblog_4=(TextView)listviewItem.findViewById(R.id.myblog_4);

        myblog myblog=myblogs.get(position);
        myblog_1.setText(myblog.getName());
        myblog_2.setText(myblog.getTitle());
        myblog_3.setText(myblog.getArticle());
        myblog_4.setText(myblog.getLike());

        return listviewItem;
    }
}
