package com.example.tugascontact;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    LayoutInflater mInflater;
    ArrayList<Contact> contacts;
    Context _context;
    OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener clickListener) {
        listener = clickListener;
    }

    public ContactAdapter(Context context, ArrayList<Contact> contact){
        this.mInflater = LayoutInflater.from(context);
        this._context = context;
        this.contacts = contact;
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvNumber, tvDelete;
        ContactAdapter mAdapter;
        public ContactViewHolder(@NonNull View itemView, ContactAdapter adapter, OnItemClickListener listener) {
            super(itemView);
            ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvNumber = (TextView) itemView.findViewById(R.id.tv_number);
            tvDelete = (TextView) itemView.findViewById(R.id.tv_delete);

            this.mAdapter = adapter;
            tvDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAbsoluteAdapterPosition());
                }
            });
        }
    }

    @NonNull @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_contact, parent, false);
        return new ContactViewHolder(view, this, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact current = contacts.get(position);

        holder.ivImage.setImageResource(current.image);
        holder.tvName.setText(current.name);
        holder.tvNumber.setText(current.number);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}

