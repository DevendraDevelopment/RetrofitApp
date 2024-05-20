package com.example.retrofitapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.ItemFeedsBinding
import com.example.retrofitapp.models.ModelFeedResponse

class FeedListAdapter(
    private var context: Context,
    private val mData: List<ModelFeedResponse>
) :
    RecyclerView.Adapter<FeedListAdapter.MyViewHolder>() {
    private var mClickListener: ItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = DataBindingUtil.inflate<ItemFeedsBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_feeds,
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mData[position], context)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class MyViewHolder internal constructor(private val binding: ItemFeedsBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        fun bind(item: ModelFeedResponse?, context: Context) {
            binding.item = item
            binding.executePendingBindings()
        }

        override fun onClick(view: View) {
            if (mClickListener != null) {
                mClickListener!!.onItemClick(view)
            }
        }
    }

    fun setClickListener(itemClickListener: ItemClickListener?) {
        mClickListener = itemClickListener
    }

    interface ItemClickListener {
        fun onItemClick(view: View?)
    }

}