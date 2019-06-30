package com.itbamchallenge.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.itbamchallenge.R
import com.itbamchallenge.adapter.ProductListAdapter
import com.itbamchallenge.model.Product
import com.itbamchallenge.network.ProductResponse
import com.itbamchallenge.network.ProductsService
import kotlinx.android.synthetic.main.activity_list_of_products.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListOfProductsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_products)

        initializeProductsList()
        setSupportActionBar(tb_superior_menu)
        supportActionBar!!.title = ""
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.superior_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun initializeProductsList() {
        val call = ProductsService.create().getProducts()

        call.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                response.body()?.let { products ->
                    populateProductList(products.products)
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                Log.e("onFailure error", t?.message)
            }
        })

    }

    private fun populateProductList(products: List<Product>) {
        findViewById<RecyclerView>(R.id.product_list_recyclerview).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = ProductListAdapter(products, context).apply {
                buttonListener = object : ProductListAdapter.buttonClickListener {
                    override fun buttonClick() {
                        Toast.makeText(context, "Adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                    }

                }
                itemListener = object : ProductListAdapter.itemClickListener {
                    override fun itemClick() {
                        val intent = Intent(context, ProductDetailsActivity::class.java)
                        startActivity(intent)
                    }

                }
            }
        }
    }

}