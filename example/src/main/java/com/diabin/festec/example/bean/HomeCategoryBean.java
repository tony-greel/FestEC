package com.diabin.festec.example.bean;

import java.util.List;

public class HomeCategoryBean{
    @Override
    public String toString() {
        return "HomeCategoryBean{" +
                "pageInfo=" + pageInfo +
                ", contentCategory=" + contentCategory +
                '}';
    }

    /**
     * pageInfo : {"total":4,"list":[{"title":"每日电影","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"在线电视","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"热门推荐","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"视频分类","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false}],"pageNum":1,"pageSize":10,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
     * contentCategory : {"categoryName":"轮播下分类"}
     */

    private PageInfoBean pageInfo;
    private ContentCategoryBean contentCategory;

    public PageInfoBean getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoBean pageInfo) {
        this.pageInfo = pageInfo;
    }

    public ContentCategoryBean getContentCategory() {
        return contentCategory;
    }

    public void setContentCategory(ContentCategoryBean contentCategory) {
        this.contentCategory = contentCategory;
    }

    public static class PageInfoBean {
        /**
         * total : 4
         * list : [{"title":"每日电影","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"在线电视","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"热门推荐","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false},{"title":"视频分类","jumpUrl":"/video/detail?id=1","jumpId":1,"iconPath":"https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg","jumpType":1,"contentType":2,"description":"元气囝仔","hasAd":false}]
         * pageNum : 1
         * pageSize : 10
         * size : 4
         * startRow : 1
         * endRow : 4
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

        private int total;
        private int pageNum;
        private int pageSize;
        private int size;
        private int startRow;
        private int endRow;
        private int pages;
        private int prePage;
        private int nextPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private int navigateFirstPage;
        private int navigateLastPage;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public int getNavigateFirstPage() {
            return navigateFirstPage;
        }

        public void setNavigateFirstPage(int navigateFirstPage) {
            this.navigateFirstPage = navigateFirstPage;
        }

        public int getNavigateLastPage() {
            return navigateLastPage;
        }

        public void setNavigateLastPage(int navigateLastPage) {
            this.navigateLastPage = navigateLastPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        @Override
        public String toString() {
            return "PageInfoBean{" +
                    "total=" + total +
                    ", pageNum=" + pageNum +
                    ", pageSize=" + pageSize +
                    ", size=" + size +
                    ", startRow=" + startRow +
                    ", endRow=" + endRow +
                    ", pages=" + pages +
                    ", prePage=" + prePage +
                    ", nextPage=" + nextPage +
                    ", isFirstPage=" + isFirstPage +
                    ", isLastPage=" + isLastPage +
                    ", hasPreviousPage=" + hasPreviousPage +
                    ", hasNextPage=" + hasNextPage +
                    ", navigatePages=" + navigatePages +
                    ", navigateFirstPage=" + navigateFirstPage +
                    ", navigateLastPage=" + navigateLastPage +
                    ", list=" + list +
                    ", navigatepageNums=" + navigatepageNums +
                    '}';
        }

        public static class ListBean {

            /**
             * title : 每日电影
             * jumpUrl : /video/detail?id=1
             * jumpId : 1
             * iconPath : https://i0.hdslb.com/bfs/bangumi/64ff380feab0a70385dfeb5d7ce109603fdb0380.jpg
             * jumpType : 1
             * contentType : 2
             * description : 元气囝仔
             * hasAd : false
             */
            public int type;
            private String title;
            private String jumpUrl;
            private long jumpId;
            private String iconPath;
            private int jumpType;
            private int contentType;
            private String description;
            private boolean hasAd;

            @Override
            public String toString() {
                return "ListBean{" +
                        "title='" + title + '\'' +
                        ", jumpUrl='" + jumpUrl + '\'' +
                        ", jumpId=" + jumpId +
                        ", iconPath='" + iconPath + '\'' +
                        ", jumpType=" + jumpType +
                        ", contentType=" + contentType +
                        ", description='" + description + '\'' +
                        ", hasAd=" + hasAd +
                        '}';
            }
            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }


            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getJumpUrl() {
                return jumpUrl;
            }

            public void setJumpUrl(String jumpUrl) {
                this.jumpUrl = jumpUrl;
            }

            public long getJumpId() {
                return jumpId;
            }

            public void setJumpId(long jumpId) {
                this.jumpId = jumpId;
            }

            public String getIconPath() {
                return iconPath;
            }

            public void setIconPath(String iconPath) {
                this.iconPath = iconPath;
            }

            public int getJumpType() {
                return jumpType;
            }

            public void setJumpType(int jumpType) {
                this.jumpType = jumpType;
            }

            public int getContentType() {
                return contentType;
            }

            public void setContentType(int contentType) {
                this.contentType = contentType;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isHasAd() {
                return hasAd;
            }

            public void setHasAd(boolean hasAd) {
                this.hasAd = hasAd;
            }
        }

    }

    public static class ContentCategoryBean {
        @Override
        public String toString() {
            return "ContentCategoryBean{" +
                    "categoryName='" + categoryName + '\'' +
                    '}';
        }

        /**
         * categoryName : 轮播下分类
         */

        private String categoryName;

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }

}
