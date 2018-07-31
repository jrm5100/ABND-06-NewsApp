package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        // Find the TextView with view ID section
        TextView articleSectionView = (TextView) listItemView.findViewById(R.id.section);
        // Set the title text in the TextView
        articleSectionView.setText(currentArticle.getSection());

        // Find the TextView with view ID article_title
        TextView articleTitleView = (TextView) listItemView.findViewById(R.id.article_title);
        // Set the title text in the TextView
        articleTitleView.setText(currentArticle.getArticleTitle());

        // Find the TextView with view ID byline
        TextView bylineView = (TextView) listItemView.findViewById(R.id.byline);
        // Set the byline text in the TextView
        bylineView.setText(currentArticle.getByline());

        // Find the TextView with the view ID date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        // Convert the original string (2018-07-24T18:17:51Z) into a friendlier date
        String dateString = "";
        try {
            SimpleDateFormat dateFormatIn = new SimpleDateFormat(
                    "yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
            SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd YYYY", Locale.US);
            Date d = dateFormatIn.parse(currentArticle.getPublishedTime());
            dateString = dateFormatOut.format(d);
        } catch(ParseException ex) {
            Log.d("DateParser", "Failed to parse");
        }
        // Set the text
        dateView.setText(dateString);

        // Return the list item view that had it's data set
        return listItemView;
    }
}