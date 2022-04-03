package com.log.analyzer.test;

import java.util.Date;

public class LogVO {
    /*
    * 10  apikey나 q가 파라미터에 없는 오류
    * 200 성공
    * 404 페이지 없음
    * */
    private String statusCode;

    /*
    * 정산적인 URL은 모두 http://apis.dktechin.net/search/ 로 시작
    * http://apis.dktechin.net/search/ 이후부터 ? 까지는 API ServiceID
    * blog , book , image , knowledge , news , vclip 중 하나
    * 쿼리 파라미터 apikey 는 영문자/숫자가 혼용된 4자리 문자열
    * 쿼리 파라미터 q 는 검색어
    * */
    private String url;
    private String apiServiceId;
    private String apiKey;
    private String apiQ;

    /*
    * IE, Firefox, Safari, Chrome, Opera
    * */
    private String webBrowser;

    private Date createDate;
    private String strCreateDate;

    public String toString(){
        return "statusCode:"+statusCode+",url:"+url+",webBrowser:"+webBrowser+",strCreateDate:"+strCreateDate;
    }

    public String toStringURL(){
        return "apiServiceId:"+apiServiceId+",apiKey:"+apiKey+",apiQ:"+apiQ;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWebBrowser() {
        return webBrowser;
    }

    public void setWebBrowser(String webBrowser) {
        this.webBrowser = webBrowser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStrCreateDate() {
        return strCreateDate;
    }

    public void setStrCreateDate(String strCreateDate) {
        this.strCreateDate = strCreateDate;
    }

    public String getApiServiceId() {
        return apiServiceId;
    }

    public void setApiServiceId(String apiServiceId) {
        this.apiServiceId = apiServiceId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiQ() {
        return apiQ;
    }

    public void setApiQ(String apiQ) {
        this.apiQ = apiQ;
    }
}
