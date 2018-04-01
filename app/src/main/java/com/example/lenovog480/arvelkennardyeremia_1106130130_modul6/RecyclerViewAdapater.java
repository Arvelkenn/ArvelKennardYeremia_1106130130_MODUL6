package com.example.lenovog480.arvelkennardyeremia_1106130130_modul6;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapater extends RecyclerView.Adapter<RecyclerViewAdapater.MyHoder>{

    List<Information> list;
    Context context;

    public RecyclerViewAdapater(List<Information> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHoder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        MyHoder myHoder = new MyHoder(view);


        return myHoder;
    }

    @Override
    public void onBindViewHolder(MyHoder holder, int position) {
        Information mylist = list.get(position);
        holder.title.setText(mylist.getTitles());
        holder.post.setText(mylist.getPost());
    }

    @Override
    public int getItemCount() {

        int arr = 0;

        try{
            if(list.size()==0){

                arr = 0;

            }
            else{

                arr=list.size();
            }



        }catch (Exception e){



        }

        return arr;

    }

    class MyHoder extends RecyclerView.ViewHolder{
        TextView title,post;


        public MyHoder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.txtJudul);
            post= (TextView) itemView.findViewById(R.id.txtDetail);

        }
    }

}
