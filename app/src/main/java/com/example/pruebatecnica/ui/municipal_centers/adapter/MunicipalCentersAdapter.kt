package com.example.pruebatecnica.ui.municipal_centers.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebatecnica.R
import com.example.pruebatecnica.data.model.MunicipalCenter
import com.example.pruebatecnica.ui.municipal_centers.adapter.MunicipalCentersAdapter.*
import kotlinx.android.synthetic.main.item_municipal_center.view.*

class MunicipalCentersAdapter(private val municipalCenters: ArrayList<MunicipalCenter>): RecyclerView.Adapter<MunicipalCentersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MunicipalCentersViewHolder {
       return MunicipalCentersViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_municipal_center, parent, false))
    }

    override fun onBindViewHolder(holder: MunicipalCentersViewHolder, position: Int) {
        holder.bind(municipalCenters[position])
    }

    override fun getItemCount(): Int {
       return municipalCenters.size
    }

    fun addMunicipalCenter(municipalCenters: List<MunicipalCenter>) {
        this.municipalCenters.apply {
            addAll(municipalCenters)
        }
    }

    fun cleanMunicipalCenter() {
        this.municipalCenters.clear()
    }

     class MunicipalCentersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
         fun bind(municipalCenter: MunicipalCenter) {
             itemView.apply {
                 nameTv.text = municipalCenter.title
             }
         }
     }
}