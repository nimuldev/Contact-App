package com.math.phone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CallAdapter extends RecyclerView.Adapter<CallAdapter.ViewHolder> {


  List<CallInformation> callInformationList;
  Context  context;

    public CallAdapter(List<CallInformation> callInformationList, Context context) {
        this.callInformationList = callInformationList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list,parent,false);


        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final CallInformation callInformation=callInformationList.get(position);
        holder.nameTv.setText(callInformation.getName());
        holder.phoneTv.setText(callInformation.getPhone());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


              Intent intent=new Intent(context, ContactInfo.class);
              intent.putExtra("name",callInformation.getName());
              intent.putExtra("work",callInformation.getWork());
              intent.putExtra("email",callInformation.getEmail());
              intent.putExtra("phone",callInformation.getPhone());
              intent.putExtra("nick",callInformation.getNick());
              intent.putExtra("relation",callInformation.getRelation());
              intent.putExtra("image",String.valueOf(callInformation.getImage()));
              context.startActivity(intent);

            }
        });


        holder.callTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(  Uri.parse("tel:" +callInformation.getPhone()));
                context.startActivity(intent);
            }
        });




    }


    @Override
    public int getItemCount() {
        return callInformationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       private TextView nameTv,phoneTv;
       private ImageView callTv,daleteIv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTv=itemView.findViewById(R.id.nameTV);
            phoneTv=itemView.findViewById(R.id.phoneTV);
            callTv=itemView.findViewById(R.id.callIV);
            daleteIv=itemView.findViewById(R.id.deleteitem);
        }
    }
}
