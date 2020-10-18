package com.voile.jule.data.model;

import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("id")
    private final Id id;

    @SerializedName("snippet")
    private final Snippet snippet;

    public Video(Id id, Snippet snippet) {
        this.id = id;
        this.snippet = snippet;
    }

    public Id getId() {
        return id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public static class Id {
        @SerializedName("videoId")
        private final String videoId;

        public Id(String videoId) {
            this.videoId = videoId;
        }

        public String getVideoId() {
            return videoId;
        }
    }

    public static class Snippet {
        @SerializedName("title")
        private final String title;

        @SerializedName("description")
        private final String description;

        @SerializedName("thumbnails")
        private final Thumbnails thumbnails;

        @SerializedName("channelTitle")
        private final String channelTitle;

        public Snippet(String title, String description, Thumbnails thumbnails,
                       String channelTitle) {
            this.title = title;
            this.description = description;
            this.thumbnails = thumbnails;
            this.channelTitle = channelTitle;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }

        public String getChannelTitle() {
            return channelTitle;
        }

        public static class Thumbnails {
            @SerializedName("default")
            private final Default aDefault;

            @SerializedName("medium")
            private final Medium medium;

            @SerializedName("high")
            private final High high;

            public Thumbnails(Default aDefault, Medium medium, High high) {
                this.aDefault = aDefault;
                this.medium = medium;
                this.high = high;
            }

            public Default getDefault() {
                return aDefault;
            }

            public Medium getMedium() {
                return medium;
            }

            public High getHigh() {
                return high;
            }

            public static class Default {
                @SerializedName("url")
                private final String url;

                @SerializedName("width")
                private final int width;

                @SerializedName("height")
                private final int height;

                public Default(String url, int width, int height) {
                    this.url = url;
                    this.width = width;
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public int getWidth() {
                    return width;
                }

                public int getHeight() {
                    return height;
                }
            }

            public static class Medium {
                @SerializedName("url")
                private final String url;

                @SerializedName("width")
                private final int width;

                @SerializedName("height")
                private final int height;

                public Medium(String url, int width, int height) {
                    this.url = url;
                    this.width = width;
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public int getWidth() {
                    return width;
                }

                public int getHeight() {
                    return height;
                }
            }

            public static class High {
                @SerializedName("url")
                private final String url;

                @SerializedName("width")
                private final int width;

                @SerializedName("height")
                private final int height;

                public High(String url, int width, int height) {
                    this.url = url;
                    this.width = width;
                    this.height = height;
                }

                public String getUrl() {
                    return url;
                }

                public int getWidth() {
                    return width;
                }

                public int getHeight() {
                    return height;
                }
            }
        }
    }
}