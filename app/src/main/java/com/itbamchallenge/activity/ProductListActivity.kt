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
import kotlinx.android.synthetic.main.activity_product_details.view.*
import kotlinx.android.synthetic.main.activity_product_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Exibe a tela produtos.
 */
class ProductListActivity : AppCompatActivity() {

    private lateinit var adapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        setupRecyclerView()
        initializeProductsList()
        setSupportActionBar(tb_superior_menu)
        supportActionBar!!.title = ""
    }

    //Inicializa a RecyclerView e o Adapter
    private fun setupRecyclerView() {
        product_list_recyclerview.setHasFixedSize(true)
        product_list_recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = ProductListAdapter().apply {
            buttonListener = object : ProductListAdapter.buttonClickListener {
                override fun buttonClick() {
                    Toast.makeText(this@ProductListActivity, "Adicionado ao carrinho!", Toast.LENGTH_SHORT).show()
                }

            }
            itemListener = object : ProductListAdapter.itemClickListener {
                override fun itemClick(product: Product) {
                    val intent = Intent(this@ProductListActivity, ProductDetailsActivity::class.java)
                    intent.putExtra(ProductDetailsActivity.PRODUCT_EXTRA, product)
                    startActivity(intent)
                }

            }
        }
        product_list_recyclerview.adapter = adapter
    }


    //Inicializa o menu superior
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.superior_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Inicializa a lista de produtos com a resposta da requisição.
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

    //Popula a lista de produtos do adapter
    private fun populateProductList(products: List<Product>) = adapter.feedProducts(products)


}