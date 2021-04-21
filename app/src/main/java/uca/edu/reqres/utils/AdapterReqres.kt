package uca.edu.reqres.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_reqres.view.*
import uca.edu.reqres.R
import uca.edu.reqres.model.Reqres

class AdapterReqres () : RecyclerView.Adapter<AdapterReqres.ViewHolder>() {

    lateinit var items: ArrayList<Reqres>

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }

    }
    fun setReqres(items: List<Reqres>) {
        this.items = items as ArrayList<Reqres>
        notifyDataSetChanged()
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_reqres, parent, false))

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.names.text="${model.first_name}  ${model.last_name}"
        holder.email.text = model.email
        Picasso.get()
            .load(model.avatar)
            .into( holder.avatar)
    }
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val avatar: ImageView = view.avatar_image
        val names: TextView = view.names
        val email: TextView = view.email
    }
}

