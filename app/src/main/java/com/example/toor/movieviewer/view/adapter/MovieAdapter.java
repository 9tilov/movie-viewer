package com.example.toor.movieviewer.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.toor.movieviewer.BR;
import com.example.toor.movieviewer.R;
import com.example.toor.movieviewer.model.data.Movie;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MoviewViewHolder> {

    private List<Movie> data;
    private ItemSelectedListener listener;

    public MovieAdapter() {
        data = new ArrayList<>();
    }

    public void setData(List<Movie> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }

    public List<Movie> getData() {
        return data;
    }

    @Override
    public MoviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.movie_item, parent, false);
        MoviewViewHolder viewHolder = new MoviewViewHolder(binding);
        binding.getRoot().setOnClickListener(v -> {
            int adapterPosition = viewHolder.getAdapterPosition();
            if (adapterPosition != RecyclerView.NO_POSITION) {
                Movie movie = data.get(adapterPosition);
                listener.onItemSelected(movie);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MoviewViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface ItemSelectedListener {
        void onItemSelected(Movie item);
    }

    public void setOnItemClickListener(ItemSelectedListener listener) {
        this.listener = listener;
    }

    static class MoviewViewHolder extends RecyclerView.ViewHolder {

        private final ViewDataBinding binding;

        MoviewViewHolder(ViewDataBinding dataBinding) {
            super(dataBinding.getRoot());
            this.binding = dataBinding;
        }

        void bind(Movie data) {
            binding.setVariable(BR.movie, data);
            binding.executePendingBindings();
        }
    }
}
