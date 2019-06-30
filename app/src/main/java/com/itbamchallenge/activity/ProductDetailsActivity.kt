package com.itbamchallenge.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itbamchallenge.R
import com.itbamchallenge.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = intent.getParcelableExtra("product")

        setContentView(R.layout.activity_product_details)
        initViews()
        btn_return.setOnClickListener{
            finish()
        }
    }

    private fun initViews() {
        product_item_name.text = product.name
        product_item_price.text = product.actualPrice
        Picasso
            .get()
            .load(product.image)
            .into(product_item_picture)

    }
}