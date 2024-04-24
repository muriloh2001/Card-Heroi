package com.example.heroicardgame.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroicardgame.databinding.ActivityMainBinding
import com.example.heroicardgame.view.adapter.HeroiAdapter
import com.example.heroicardgame.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HeroiAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = HeroiAdapter(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setAdapter()
        setObservers()


        binding.btnNovo.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }

    }

    fun setObservers(){
        viewModel.getListViewModel().observe(this){
            adapter.updateAdapter(it)
        }
        viewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
    }

    fun setAdapter(){

        binding.rcvHerois.layoutManager = LinearLayoutManager(this)
        binding.rcvHerois.adapter = adapter

        adapter.onItemLongClick = {
            val h = adapter.listaAdapter[it]
            viewModel.deletar(h)
            viewModel.getListFromDB()
        }

        adapter.onItemClick = {
            val h = adapter.listaAdapter[it]
            val intent = Intent(this, HeroiActivity::class.java)
            intent.putExtra("id", h.id)
            startActivity(intent)
        }



    }

    override fun onResume() {
        super.onResume()
        viewModel.getListFromDB()
    }


}