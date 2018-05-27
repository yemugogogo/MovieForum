package com.example.jingjing.blogv6;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class tabc extends RelativeLayout {
    private Context myContext;
    private Context mainContext;
    private View view02;
    private Button button1;
    private Button button2;

    ListView listView;
    private SearchView searchView;
    String search;

//抄範例
    ArrayList<Article> articleDB;
    ArrayList<Article> articlePeter;
    ArrayList<Article> articleGinger;
    ArrayList<Article> articletest;
    ArrayList<Attention> attenName;
    ArrayList<Attention> attentionDB;


    private final Lock lock = new ReentrantLock();
    private final Condition dbReady = lock.newCondition();


    public void setMainContext(Context mainContext) {
        this.mainContext = mainContext;
    }
    public tabc(Context context) {
        super(context);
        myContext = context;
        view02 = LayoutInflater.from(myContext).inflate(R.layout.tabc, null);
        addView(view02);

        button1=(Button) findViewById(R.id.atten);
        button2=(Button) findViewById(R.id.unatten);
        searchView=(SearchView) findViewById(R.id.searchtabc);
        listView=(ListView) findViewById(R.id.attenlist);
        //search = searchView.getQuery().toString();//get string in searchview

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openest();
                getArticleCFS1();
                Log.e("ooo", "onClick registered for tabc class");


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //openest();
                getArticleCFS2();
                Log.e("ooo", "onClick registered for tabd class");


            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                search=searchView.getQuery().toString();
                getArticleCFS();
                Log.e("jjjjjj","OMG");
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
    }

    public void databaseReady() {
        Log.e("itspeter", "databaseReady: What's the size ?" + articleDB.size());
        Toast.makeText(myContext, "Database reading done !", Toast.LENGTH_SHORT).show();

        articlePeter = new ArrayList<>();
        articleGinger = new ArrayList<>();
        articletest = new ArrayList<>();


        for (int i=0; i<articleDB.size(); ++i) {
            Log.e("ooo", "|" + articleDB.get(i).getName() + "|");
            if (articleDB.get(i).getName().equals(LoginActivity.user))
                articleGinger.add(articleDB.get(i));
        }

//        for (int i=0; i<articleDB.size(); ++i) {
//            Log.e("ooo", "|" + articleDB.get(i).getName() + "|");
//            if (articleDB.get(i).getName().equals("Peter")) {
//                articlePeter.add(articleDB.get(i));
//            }
//        }

        for (int i=0; i<articleDB.size(); ++i) {
            Log.e("ooo", "|" + articleDB.get(i).getName() + "|");
            if (articleDB.get(i).getName().equals(search)) {
                articletest.add(articleDB.get(i));
            }
        }


        /*ArrayAdapter adapterDB = new Bloglist_myblog((Activity) myContext, articleDB);
        ArrayAdapter adapterGinger = new Bloglist_myblog((Activity) myContext, articleGinger);
        ArrayAdapter adapterPeter = new Bloglist_myblog((Activity) myContext, articlePeter);*/
        ArrayAdapter adaptertest =  new Bloglist_myblog((Activity) myContext, articletest);

        //mybloglist.setAdapter(adapterDB);
        //mybloglist.setAdapter(adapterGinger);
        //listView.setAdapter(adapterPeter);
        listView.setAdapter(adaptertest);
    }

    public void databaseReady1() {
        Log.e("ooo", "Thread End. What's the size ?" + attentionDB.size());
        Toast.makeText(myContext, "Database reading done !", Toast.LENGTH_SHORT).show();
        attenName = new ArrayList<>();
        for(int i=0;i<attentionDB.size();++i){
            Log.e("ooo", "|" + attentionDB.get(i).getOwner() + "|" + attentionDB.get(i).getBlgger_name() + "|");
            if (attentionDB.get(i).getOwner().equals(LoginActivity.user)){//if user name="Ginger"
                attenName.add(attentionDB.get(i));
            }
        }

//        for(int i=0;i<attenName.size();++i){
//            Log.e("ooo", " Found - |" + attenName.get(i).getOwner() + "|" + attenName.get(i).getBlgger_name() + "|");
//        }
        //ArrayAdapter adapterPeter = new Bloglist_myblog((Activity) myContext, articlePeter);

        ArrayAdapter adapterName = new Attenlist((Activity) myContext,attenName);

        //listView.setAdapter(adapterPeter);
        listView.setAdapter(adapterName);

    }

    public void databaseReady2() {
        Log.e("itspeter", "databaseReady2. What's the size ?" + articleDB.size());
        Toast.makeText(myContext, "Database reading done !", Toast.LENGTH_SHORT).show();

        articlePeter = new ArrayList<>();
        articleGinger = new ArrayList<>();

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


        ArrayAdapter adapterDB = new Bloglist_myblog((Activity) myContext, articleDB);
        ArrayAdapter adapterGinger = new Bloglist_myblog((Activity) myContext, articleGinger);
        ArrayAdapter adapterPeter = new Bloglist_myblog((Activity) myContext, articlePeter);

        //mybloglist.setAdapter(adapterDB);
        listView.setAdapter(adapterGinger);
        //listView.setAdapter(adapterPeter);
    }

    public void getArticleCFS() {
        // Filter example also at: https://firebase.google.com/docs/firestore/query-data/queries
        // https://medium.com/google-developers/why-are-firebase-apis-asynchronous-callbacks-promises-tasks-e037a6654a93
        Toast.makeText(myContext, "Reading database......", Toast.LENGTH_SHORT).show();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        articleDB = new ArrayList<>();
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
                            databaseReady();
                        } else {
                            Log.w("itspeter", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void getArticleCFS1() {
        // Filter example also at: https://firebase.google.com/docs/firestore/query-data/queries
        // https://medium.com/google-developers/why-are-firebase-apis-asynchronous-callbacks-promises-tasks-e037a6654a93
        Toast.makeText(myContext, "Reading database......", Toast.LENGTH_SHORT).show();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        attentionDB = new ArrayList<>();
        db.collection("Attention")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            Log.d("ooo", "getArticleCFS1 running");
                            for (DocumentSnapshot document : task.getResult()) {
                                Log.d("ooo", document.getId() + " => " + document.getData());
                                JSONObject tmpJsonobj = new JSONObject(document.getData());
                                // Convert to Movie class
                                try {
                                    Attention attention = new Attention(
                                            tmpJsonobj.getString("owner"),
                                            //tmpJsonobj.getString("article"),
                                            tmpJsonobj.getString("blogger name")
                                    );
                                    attentionDB.add(attention);
                                    //待註解
                                    /*Article article = new Article(
                                            tmpJsonobj.getString("name"),
                                            "標題"+tmpJsonobj.getString("title"),
                                            "文章"+tmpJsonobj.getString("article"),
                                            "熱度"+tmpJsonobj.getString("like"));
                                    articleDB.add(article);*/
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            Log.e("ooo", "start before databaseReady1");
                            databaseReady1();
                            Log.e("ooo", "after databaseReady1");
                        } else {
                            Log.w("itspeter", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void getArticleCFS2() {
        // Filter example also at: https://firebase.google.com/docs/firestore/query-data/queries
        // https://medium.com/google-developers/why-are-firebase-apis-asynchronous-callbacks-promises-tasks-e037a6654a93
        Toast.makeText(myContext, "Reading database......", Toast.LENGTH_SHORT).show();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        articleDB = new ArrayList<>();
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
                                            tmpJsonobj.getString("title"),
                                            tmpJsonobj.getString("article"),
                                            "熱度"+tmpJsonobj.getString("like"));
                                    articleDB.add(article);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            databaseReady2();
                        } else {
                            Log.w("itspeter", "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
