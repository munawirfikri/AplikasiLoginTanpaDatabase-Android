package com.munawirfikri.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListActivity extends AppCompatActivity {

    private ListView listView;
    private TextView email, web, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);

        listView = findViewById(R.id.CustomListView);
        ArrayList<ModelContact> listContact = new ArrayList<>();

        ModelContact m1, m2, m3;
        m1 = new ModelContact(R.drawable.photo9, "Mun", "mun@tupailabs.com", "082392100328", "www.munawirfikri.com");
        m2 = new ModelContact(R.drawable.photo8, "Dana", "dana@tupailabs.com", "082392100329", "www.dana.com");
        m3 = new ModelContact(R.drawable.photo7, "Apidkun", "apid@tupailabs.com", "082392100330", "www.hafidh.com");


        listContact.add(m1);
        listContact.add(m2);
        listContact.add(m3);

        listView.setAdapter(new CustomAdapter(this, R.layout.single_list,  listContact));
    }

    public void webOnClick(View view) {
        LinearLayout baris = (LinearLayout) view.getParent();
        web = (TextView) baris.getChildAt(0);

        Intent url = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://" + web.getText().toString()));
        startActivity(url);
    }

    public void phoneOnClick(View view) {
        LinearLayout baris = (LinearLayout) view.getParent();
        phone = (TextView) baris.getChildAt(0);

        Intent call = new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:"+phone.getText().toString()));
        startActivity(call);
    }

    public void mailOnClick(View view) {
        LinearLayout baris = (LinearLayout) view.getParent();
        email = (TextView) baris.getChildAt(0);

        Intent mail = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", email.getText().toString(), null
        ));
        mail.putExtra(Intent.EXTRA_SUBJECT, "Subjek");
        mail.putExtra(Intent.EXTRA_TEXT, "Isi Pesan");
        startActivity(mail);
    }
}
