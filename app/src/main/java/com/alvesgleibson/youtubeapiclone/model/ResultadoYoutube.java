package com.alvesgleibson.youtubeapiclone.model;


public class ResultadoYoutube {
    String part, order, maxResults, key, channelId;

    public ResultadoYoutube(String part, String order, String maxResults, String key, String channelId) {
        this.part = part;
        this.order = order;
        this.maxResults = maxResults;
        this.key = key;
        this.channelId = channelId;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(String maxResults) {
        this.maxResults = maxResults;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
