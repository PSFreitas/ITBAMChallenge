package com.itbamchallenge.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itbamchallenge.R
import com.itbamchallenge.model.Product
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_details.*

/**
 * Exibe a tela de detalhes do produto.
 */
class ProductDetailsActivity : AppCompatActivity() {

    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(intent.hasExtra(PRODUCT_EXTRA))
            product = intent.getParcelableExtra("product")

        setContentView(R.layout.activity_product_details)
        populateProductDetails()
        btn_return.setOnClickListener{
            finish()
        }
    }

    //Inicializa as views com os dados do produto.
    private fun populateProductDetails() {
        product_item_name.text =  product.name
        product_item_price.text = product.actualPrice
        product_item_color.text = product.color
        product_item_installments.text = product.installments
        if(product.image.isNotEmpty()){
            Picasso
                .get()
                .load(product.image)
                .into(product_item_picture)
        }

    }
    companion object{
        val PRODUCT_EXTRA: String = "product"
    }
}