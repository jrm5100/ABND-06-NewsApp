package com.example.android.newsapp;

/**
 * An {@link Article} contains relevant info for a news article
 */
public class Article {

    /** Pillar is like a main section */
    // example: pillarName: "Sport"
    private String mPillar;

    /** Section is like a sub-section */
    // example: sectionName: "Sport"
    private String mSection;

    /** When the article was published */
    // example: webPublicationDate: "2018-07-24T18:17:51Z"
    private String mPublishedTime;

    /** Title of the article */
    // example: webTitle: "County cricket: Yorkshire beat Lancashire, Surrey thrash Notts –&nbsp;as it happened"
    private String mTitle;

    /** Byline contains author info */
    // example: fields: byline: "Graham Hardcastle at Old Trafford"
    private String mByline;

    /** Url to the article */
    // example: webUrl: https://www.theguardian.com/sport/live/2018/jul/24/county-cricket-lancashire-v-yorkshire-notts-v-surrey-and-more-live
    private String mUrl;

    /**
     * Constructs a new {@link Article} object.
     */
    public Article(String pillar, String section, String publishedTime,
                      String title, String byLine, String url) {
        mPillar = pillar;
        mSection = section;
        mPublishedTime = publishedTime;
        mTitle = title;
        mByline = byLine;
        mUrl = url;
    }

    // Public Getters

    /** Get Pillar*/
    public String getPillar(){return mPillar;}

    /** Get Section*/
    public String getSection(){return mSection;}

    /** Get Published Time*/
    public String getPublishedTime(){return mPublishedTime;}

    /** Get Article's Title*/
    public String getArticleTitle(){return mTitle;}

    /** Get Byline (author info)*/
    public String getByline(){
        if (mByline.equals("")) {
            return "No Author Listed";
        } else {
            return mByline;
        }}

    /** Get Url to the article*/
    public String getUrl(){return mUrl;}


}
