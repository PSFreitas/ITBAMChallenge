package com.itbamchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itbamchallenge.R
import com.itbamchallenge.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_item.view.*

class ProductListAdapter(
    private var products: List<Product>,
    private var context: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    var buttonListener : buttonClickListener? = null
    var itemListener : itemClickListener? = null

    interface itemClickListener{
        fun itemClick(product: Product)
    }

    interface buttonClickListener{
        fun buttonClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder?.let {
            it.bindView(product)
        }
        holder?.let{
            it.itemView.btn_add_to_cart.setOnClickListener{
                buttonListener?.buttonClick()
            }
        }
        holder?.let{
            it.itemView.setOnClickListener{
                itemListener?.itemClick(products[position])
            }
        }
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(product: Product) {
            val productName = itemView.product_item_name
            val productPrice = itemView.product_item_price
            val productPicture = itemView.product_item_picture
            productName.text = product.name
            productPrice.text = product.actualPrice


            if(product.image.isNotEmpty()){
                Picasso
                    .get()
                    .load(product.image)
                    .resize(250,250)
                    .centerCrop()
                    .into(productPicture)
            }

        }

    }

}