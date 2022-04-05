package com.log.analyzer.test;

import java.util.*;

// Open API 담당자인 당신은 로그 분석을 위한 프로그램이 필요합니다.
// Open API 호출 기록은 모두 웹 로그 형태로 남아 있습니다.
// 첨부한 로그 파일을 분석하여 아래 결과를 파일로 출력하는 프로그램을 구현해 주세요.
// 1. 최다호출 apikey
// 2. (호출 횟수 기준)상위 3개의 API ServiceID와 각각의 요청 수
// 3. 웹브라우저별 사용 비율
// - 호출횟수는 상태코드가 200 으로 정상인 경우에만 카운트해야 합니다.
// - 최대호출 APIKEY : 호출횟수가 가장 많은 APIKEY
// - 상위 3개의 API ServiceId와 각각의 요청 수 : 요청 수가 상위 3위 이내인 APIServiceID와 요청 횟수 출력
// - 요청 횟수가 동일한 경우가 발생하면 어떤것을 출력해도 상관없음
// - 웹브라우저별 사용 비율 : 정상요청인 경우, 요청 브라우저의 사용 비율
public class LogServiceImpl{

    //private String[] webBrowser = {"ie","firefox","safari","chrome","opera"};
    //private String[] apiServiceId = {"blog","book","image","knowledge","news","vclip"};

    public String makeRankString(String txt) {
        String[] strLogArray = {"[200][http://apis.dktechin.net/search/knowledge?apikey=23jf&q=dktechin][IE][2019-06-10 08:00:00]"
                ,"[200][http://apis.dktechin.net/search/knowledge?apikey=dcj8&q=dktechin][IE][2019-06-10 08:00:01]"
                ,"[200][http://apis.dktechin.net/search/blog?apikey=wejf&q=dktechin][IE][2019-06-10 08:00:02]"
                ,"[200][http://apis.dktechin.net/search/knowledge?apikey=e3ea&q=dktechin][IE][2019-06-10 08:00:03]"
                ,"[200][http://apis.dktechin.net/search/vclip?apikey=2jdc&q=dktechin][IE][2019-06-10 08:00:04]"};

        // 집계 결과를 저장할 맵
        Map<String,Integer> countWebBrowserMap = new HashMap<>();
        Map<String,Integer> countApiServiceIdMap = new HashMap<>();
        Map<String,Integer> countApiKeyMap = new HashMap<>();

        Iterator<String> strLogItr = Arrays.asList(strLogArray).iterator();
        while(strLogItr.hasNext()) {
            // [0]상태코드 [1]URL [2]웹브라우저 [3]호출시간
            String[] column = strLogItr.next().replaceAll("\\[","").split("\\]");

            // 200 호출 성공 건에 대해서 집계를 수행합니다.
            if(!column[0].equals("200")) continue;

            // 집계 - 1.웹브라우저 이름을 키로 가진 카운트를 계산합니다.
            countValue(countWebBrowserMap, column[2]);

            // 집계 - 2.api service id를 키로 가진 카운트를 계산합니다.
            String[] slushSplit = column[1].split("\\/");
            String[] apiServiceSplit = slushSplit[slushSplit.length-1].split("\\?");
            countValue(countApiServiceIdMap, apiServiceSplit[0]);

            // 집계 - 3.api key를 키로 가진 카운트를 계산합니다.
            String[] paramSplit = apiServiceSplit[1].split("\\&");
            String[] keyValueSplit = paramSplit[0].split("=");
            countValue(countApiKeyMap, keyValueSplit[1]);
        }

        // output.log에 저장할 문자열 생성
        StringBuilder sb = new StringBuilder();
        sb.append(getFirstResult(countApiKeyMap)).append("\n");
        sb.append(getSecondResult(countApiServiceIdMap)).append("\n");
        sb.append(getThirdResult(countWebBrowserMap));
        System.out.println(sb);

        return sb.toString();
    }

    String getThirdResult(Map<String,Integer> countWebBrowserMap) {
        int totalCount = countWebBrowserMap.values().stream().reduce(0, Integer::sum);
        String retStr = "웹브라우저별 사용비율 \n";
        for(String key : countWebBrowserMap.keySet()) {
            retStr += key +" : "+ countWebBrowserMap.get(key) / totalCount * 100 + "%";
        }
        return retStr;
    }

    String getSecondResult(Map<String,Integer> countApiServiceIdMap) {
        List<Map<String,Integer>> rankedList = new ArrayList<>();
        Map<String,Integer> totalMap = null;

        for(int i=0;i<3;i++) {
            String maxKey = "";
            int maxCount = 0;
            boolean isContinue = false;

            for(String key : countApiServiceIdMap.keySet()) {

                for(Map<String,Integer> tempData : rankedList) {
                    if(tempData.containsKey(key)) isContinue = true;
                }

                if(isContinue) {
                    isContinue = false;
                    continue;
                }

                if(maxCount < countApiServiceIdMap.get(key)) {
                    maxKey = key;
                    maxCount = countApiServiceIdMap.get(key);
                }
            }
            totalMap = new HashMap<String,Integer>();
            totalMap.put(maxKey, maxCount);
            rankedList.add(totalMap);
        }

        String retStr = "상위 3개의 API ServiceID와 각각의 요청 수 \n";
        for(Map<String,Integer> rankedData : rankedList) {
            for(String key : rankedData.keySet()) {
                retStr += key +" : "+ rankedData.get(key)  + "\n";
            }
        }
        return retStr;
    }

    String getFirstResult(Map<String,Integer> countApiKeyMap) {
        int maxApiKeyValue = Collections.max(countApiKeyMap.values());
        String maxApiKey = "";
        for(String key : countApiKeyMap.keySet()) {
            if(countApiKeyMap.get(key) == maxApiKeyValue) {
                maxApiKey = key;
            }
        }
        return "최대 호출 APIKEY\n" + maxApiKey+"\n";
    }

    void countValue(Map<String, Integer> logResultMap, String key) {
        if(logResultMap.get(key) == null) {
            logResultMap.put(key,1);
        } else {
            logResultMap.put(key,logResultMap.get(key)+1);
        }
    }

}
