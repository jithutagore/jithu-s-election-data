package com.jithu.electionData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.ViewHolder> {

    List<SingleRow> member;

    public SearchResultAdapter(List<SingleRow> member) {
        this.member = member;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.person_single_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.boothNumber.setText(member.get(position).getBoothNumber());
        holder.serialNumber.setText(member.get(position).getPersonId());
        holder.name.setText(member.get(position).getName());
        holder.parentName.setText(member.get(position).getParentName());
        holder.genderAndAge.setText(member.get(position).getGenderAndAge());
        holder.houseName.setText(member.get(position).getHouseName());
        holder.houseNo.setText(member.get(position).getHouseNumber());
        holder.VotersIdNo.setText(member.get(position).getIdCardNo());
        holder.boothName.setText(member.get(position).getBoothName());

    }

    @Override
    public int getItemCount() {
        return member.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView boothNumber, serialNumber, name
                , parentName, genderAndAge, houseName
                , houseNo, VotersIdNo, boothName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            boothNumber = itemView.findViewById(R.id.boothNumber);
            serialNumber = itemView.findViewById(R.id.serialNumber);
            name = itemView.findViewById(R.id.name);
            parentName = itemView.findViewById(R.id.parentName);
            genderAndAge = itemView.findViewById(R.id.genderAndAge);
            houseName = itemView.findViewById(R.id.houseName);
            houseNo = itemView.findViewById(R.id.houseNo);
            VotersIdNo = itemView.findViewById(R.id.VotersIdNo);
            boothName = itemView.findViewById(R.id.boothName);

        }
    }
}
