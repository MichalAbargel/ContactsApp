package com.example.contactsapp.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapp.R;
import com.example.contactsapp.models.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder>{

    private List<Contact> contacts;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onEditClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }


    public void setContacts(List<Contact> contacts) {
            this.contacts = contacts;
            notifyDataSetChanged();
        }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact, parent, false);
        return new ContactViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contact contact = contacts.get(position);
        holder.bind(contact);
    }

    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

    static class ContactViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private ImageView imageViewEdit;
        private ImageView imageViewDelete;

        public ContactViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.textViewName);
            imageViewEdit = itemView.findViewById(R.id.imageViewEdit);
            imageViewDelete = itemView.findViewById(R.id.imageViewDelete);

            // Set click listeners for edit and delete icons
            imageViewEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onEditClick(position);
                        }
                    }
                }
            });

            imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onDeleteClick(position);
                        }
                    }
                }
            });
        }

        public void bind(Contact contact) {
            textViewName.setText(contact.getName());
        }
    }

}
