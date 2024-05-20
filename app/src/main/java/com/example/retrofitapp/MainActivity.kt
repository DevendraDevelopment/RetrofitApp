package com.example.retrofitapp

import android.app.ProgressDialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.retrofitapp.adapters.FeedListAdapter
import com.example.retrofitapp.databinding.ActivityMainBinding
import com.example.retrofitapp.viewModels.FeedsViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[FeedsViewModel::class.java]
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        val p = ProgressDialog(this)
        p.setMessage("Data loading... ")
        p.show()

        viewModel.feeds.observe(this) {
            p.dismiss()
            binding!!.recyclerView.adapter = FeedListAdapter(this, it)
        }
    }
}