package brendaukdw.com.ttsrecyclerview_doctor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import models.Doctor;

/**
 * Created by Brenda on 23/10/2017.
 */

public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.MyViewHolder>{

    private List<Doctor> doctorList;
    
    public DoctorAdapter(List<Doctor> doctorList){
        this.doctorList = doctorList;
    }


    @Override
    public DoctorAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dokter_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DoctorAdapter.MyViewHolder holder, int position) {
        Doctor dr = doctorList.get(position);
        Context cont = holder.urlfoto.getContext();
        int id = cont.getResources().getIdentifier(dr.getUrlfoto(), "drawable", cont.getPackageName());
        holder.urlfoto.setImageResource(id);
        holder.nama.setText(dr.getNama());
        holder.spesialisasi.setText(dr.getSpesialisasi());
        holder.alamat.setText(dr.getAlamat());
    }

    @Override
    public int getItemCount() {
        return doctorList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nama, alamat, spesialisasi;
        public ImageView urlfoto;
        public MyViewHolder(View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.tvNama);
            spesialisasi = (TextView)itemView.findViewById(R.id.tvSpesialisasi);
            alamat = (TextView)itemView.findViewById(R.id.tvAlamat);
            urlfoto = (ImageView)itemView.findViewById(R.id.imgDokter);

        }
    }
}
