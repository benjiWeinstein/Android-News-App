package com.example.afinal.ui.search

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.afinal.data.models.Article
import com.example.afinal.databinding.FragmentArticleBinding


class searchAdapter(private val listener : ArticleItemListener) :
    RecyclerView.Adapter<searchAdapter.ArticleViewHolder>() {

    private val articles = ArrayList<Article>()

    class ArticleViewHolder(private val itemBinding: FragmentArticleBinding,
                            private val listener: ArticleItemListener)
        : RecyclerView.ViewHolder(itemBinding.root),
        View.OnClickListener {

        private lateinit var article: Article

        init {
            itemBinding.root.setOnClickListener(this)
        }

        fun bind(item: Article) {
            this.article = item
            itemBinding.aritcleTitle.text = item.title
            Glide.with(itemBinding.root)
                .load(item.urlToImage)
                .circleCrop()
                .into(itemBinding.image)
        }

        override fun onClick(v: View?) {
            listener.onArticleClick(article.id)
        }
    }

    fun setArticles(article : Collection<Article>) {
        this.articles.clear()
        Log.d("apples", article.toString())
        this.articles.addAll(article.distinctBy { article -> article.title })
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = FragmentArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArticleViewHolder(binding,listener)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) =
        holder.bind(articles[position])


    override fun getItemCount() = articles.size

    interface ArticleItemListener {
        fun onArticleClick(characterId : Int)
    }
}
