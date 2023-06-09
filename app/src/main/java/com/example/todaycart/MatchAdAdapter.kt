package com.example.todaycart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MatchAdAdapter (context: Context, layout : Int, mads : MutableList<MatchAdVO>): RecyclerView.Adapter<MatchAdAdapter.ViewHolder>() {

    val context = context
    val layout = layout
    val mads = mads
    val inflater = LayoutInflater.from(context)


    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val mtimg1 : ImageView = view.findViewById(R.id.mtimg1)
        val mtimg2 : ImageView = view.findViewById(R.id.mtimg2)
        val mtimg3 : ImageView = view.findViewById(R.id.mtimg3)
        val mtName1 : TextView = view.findViewById(R.id.mtTvName1)
        val mtName2 : TextView = view.findViewById(R.id.mtTvName2)
        val mtName3 : TextView = view.findViewById(R.id.mtTvName3)
        val mtPrice1 : TextView = view.findViewById(R.id.mtTvPrice1)
        val mtPrice2 : TextView = view.findViewById(R.id.mtTvprice2)
        val mtPrice3 : TextView = view.findViewById(R.id.mtTvprice3)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.matchad_list,parent,false)
        return MatchAdAdapter.ViewHolder(view)
    }

    class ViewHorlder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.mtimg1.setImageResource(mads[position].pimg1)
        holder.mtimg2.setImageResource(mads[position].pimg2)
        holder.mtimg3.setImageResource(mads[position].pimg3)
        holder.mtName1.text = mads[position].mname1
        holder.mtName2.text = mads[position].mname2
        holder.mtName3.text = mads[position].mname3
        holder.mtPrice1.text = mads[position].mprice1
        holder.mtPrice2.text = mads[position].mprice2
        holder.mtPrice3.text = mads[position].mprice3
    }

    override fun getItemCount(): Int {
        return mads.size
    }

}
