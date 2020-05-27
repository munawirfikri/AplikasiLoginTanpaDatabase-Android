package com.munawirfikri.tugasakhir;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ModelContact>
{
    private List<ModelContact> listContact;
    private Context mContext;
    private int layout;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<ModelContact> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listContact = objects;
        this.layout = resource;
    }

    static class ContactHolder{
        ImageView fotoContact;
        TextView namaContact;
        TextView emailContact;
        TextView phoneContact;
        TextView webContact;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        ContactHolder holder;

        if ( v == null )
        {
            LayoutInflater li = ((Activity)mContext).getLayoutInflater();
            v = li.inflate(layout,parent, false);

            holder = new ContactHolder();
            holder.fotoContact = v.findViewById(R.id.list_foto);
            holder.namaContact = v.findViewById(R.id.list_nama);
            holder.emailContact = v.findViewById(R.id.list_email);
            holder.phoneContact = v.findViewById(R.id.list_phone);
            holder.webContact = v.findViewById(R.id.list_web);

            v.setTag(holder);
        }else
        {
            holder = (ContactHolder) v.getTag();
        }

        ModelContact contact = listContact.get(position);
        holder.fotoContact.setImageResource(contact.getmImage());
        holder.namaContact.setText(contact.getNama());
        holder.emailContact.setText(contact.getEmail());
        holder.phoneContact.setText(contact.getPhone());
        holder.webContact.setText(contact.getWeb());

        return v;
    }
}
