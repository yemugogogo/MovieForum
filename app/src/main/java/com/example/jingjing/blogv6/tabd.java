package com.example.jingjing.blogv6;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tabd extends RelativeLayout {
    private Button button;
    private Context myContext;
    private View view01;

    GetCFS cfs;
    Button button2;
    ListView mybloglist;

    ArrayList<Article> articleDB;
    ArrayList<Article> articlePeter;
    ArrayList<Article> articleGinger;

    public tabd(Context context) {
        super(context);
        myContext = context;
        view01 = LayoutInflater.from(myContext).inflate(R.layout.tabd, null);
        addView(view01);

        button = (Button)findViewById(R.id.button);
        //button2= (Button)findViewById(R.id.button2);

        cfs = new GetCFS();
        Thread t = new Thread(cfs);
        t.start();
        try {
            t.join(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        articleDB = cfs.articleDB;
        Log.e("itspeter", "Thread End. What's the size ?" + cfs.articleDB.size());

        articlePeter = new ArrayList<>();
        articleGinger = new ArrayList<>();
        mybloglist=(ListView)findViewById(R.id.mybloglist);

        //getArticleCFS();

        for (int i=0; i<articleDB.size(); ++i) {
            Log.e("ooo", "|" + articleDB.get(i).getName() + "|");
            if (articleDB.get(i).getName().equals("Ginger"))
                articleGinger.add(articleDB.get(i));
        }

        for (int i=0; i<articleDB.size(); ++i) {
            Log.e("ooo", "|" + articleDB.get(i).getName() + "|");
            if (articleDB.get(i).getName().equals("Peter")) {
                articlePeter.add(articleDB.get(i));
            }
        }

        //ArrayAdapter adapter = new Bloglist_myblog((Activity) myContext, articleDB);
        ArrayAdapter adapter = new Bloglist_myblog((Activity) myContext, articlePeter);
        //ArrayAdapter adapter = new Bloglist_myblog((Activity) myContext, articleDB);

        mybloglist.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openest();
                Log.e("ooo", "onClick registered for tabd class");
            }
        });
    }

    public void openest() {
        Log.e("kkk", "Button clicked");
        //removeAllViews();
        //addView(view02);

        Intent intent = new Intent(myContext, test.class);
        myContext.startActivity(intent);
        //button.setText("I'm clicked!");
    }

    public void getArticleCFS() {
    }
}

class GetCFS implements Runnable {
    public ArrayList<Article> articleDB;

    @Override
    public void run() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Article_CFS")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d("itspeter", document.getId() + " => " + document.getData());
                                JSONObject tmpJsonobj = new JSONObject(document.getData());
                                // Convert to Movie class
                                try {
                                    Article article = new Article(
                                            tmpJsonobj.getString("name"),
                                            "標題"+tmpJsonobj.getString("title"),
                                            "文章"+tmpJsonobj.getString("article"),
                                            "熱度"+tmpJsonobj.getString("like"));
                                    articleDB.add(article);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            Log.w("itspeter", "Error getting documents.", task.getException());
                        }
                    }
                });

    }
}

class tabd1 extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    Button button2;
    ListView mybloglist;
    List<Article> Article;
    Context myContext;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabd);


    }
}
