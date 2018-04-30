package com.mindorks.mvp.ui.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mindorks.mvp.R;
import com.mindorks.mvp.model.DosenResponse;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private DosenResponse dosen;

    public MainAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.row_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvNama.setText(dosen.getDosen().get(position).getNama());
        holder.tvNip.setText(dosen.getDosen().get(position).getNik());
        holder.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, dosen.getDosen().get(position).getJabatan(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dosen.getDosen().size();
    }

    public void addItem(DosenResponse dosen) {
        this.dosen = dosen;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNama, tvNip;
        private Button btnUpdate;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNama = (TextView) itemView.findViewById(R.id.tv_nama);
            tvNip = (TextView) itemView.findViewById(R.id.tv_nip);
            btnUpdate = (Button) itemView.findViewById(R.id.btn_update);
        }
    }
}
