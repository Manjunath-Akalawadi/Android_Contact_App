package com.manju7.contact_app;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends AppCompatActivity {

    private Button view , add ;
    private ListView list;

    private String orderBy = ContactsContract.Contacts.DISPLAY_NAME_PRIMARY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view = (Button) findViewById(R.id.viewcontact);
        add = (Button) findViewById(R.id.add);
        list = (ListView) findViewById(R.id.list);

    }

    public void getAll(View v){

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        ,null,null,null,orderBy);

        String[] str = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Phone._ID};

        int[] to = {android.R.id.text1,android.R.id.text2};

        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_2
        ,cursor,str,to);

        list.setAdapter(simpleCursorAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

    }

}
