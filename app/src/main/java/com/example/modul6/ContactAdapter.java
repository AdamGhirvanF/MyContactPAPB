package com.example.modul6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>
{
    private Context context;
    private List<ContactModel> contactList;
    private static ClickListener clickListener;
    public ContactAdapter(Context context,
                          ArrayList<ContactModel> contactList){
        this.context = context;
        this.contactList = contactList;
    }
    @NonNull
    @Override
    public ContactViewHolder
    onCreateViewHolder(@NonNull ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ContactViewHolder extends
            RecyclerView.ViewHolder implements View.OnClickListener
    {
        LinearLayout contactLayout;
        TextView tvName, tvNumber, tvCall, tvMessage,
                tvWhatsapp, tvDelete;
        public ContactViewHolder(@NonNull View
                                         itemView) {
            super(itemView);
            contactLayout =
                    itemView.findViewById(R.id.contact_layout);
            tvDelete =
                    itemView.findViewById(R.id.tv_delete);
            tvName =
                    itemView.findViewById(R.id.tv_name);
            tvNumber =
                    itemView.findViewById(R.id.tv_number);
            tvCall =
                    itemView.findViewById(R.id.tv_call);
            tvMessage =
                    itemView.findViewById(R.id.tv_message);
            tvWhatsapp =
                    itemView.findViewById(R.id.tv_whatsapp);
            tvDelete.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), itemView);
        }
    }

    public void setOnItemClickListener(ContactAdapter.ClickListener clickListener) {
        ContactAdapter.clickListener = clickListener;
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
    }

}

