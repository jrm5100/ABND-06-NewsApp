package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * An {@link ArticleAdapter} creates a list item layout for each article
 * in the data source (list of {@link Article} objects).
 */
public class ArticleAdapter extends ArrayAdapter<Article> {

    /**
     * Constructs a new {@link ArticleAdapter}.
     *
     * @param context of the app
     * @param articles is the list of articles, which is the data source of the adapter
     */
    public ArticleAdapter(Context context, List<Article> articles) {
        super(context, 0, articles);
    }

    /**
     * Returns a list item view that displays information about the article at the given position
     * in the list of articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Article currentArticle = getItem(position);

        // Find the TextView with view ID article_title
        TextView articleTitleView = (TextView) listItemView.findViewById(R.id.article_title);
        // Set the title text in the TextView
        articleTitleView.setText(currentArticle.getArticleTitle());

        // Find the TextView with view ID byline
        TextView bylineView = (TextView) listItemView.findViewById(R.id.byline);
        // Set the byline text in the TextView
        bylineView.setText(currentArticle.getByline());

        // Return the list item view that had it's data set
        return listItemView;
    }
}