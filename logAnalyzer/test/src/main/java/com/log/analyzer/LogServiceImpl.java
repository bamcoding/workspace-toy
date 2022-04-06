package com.log.analyzer;

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

    /**
     * output.log의 내용을 구성합니다.
     * @param lines
     * @return
     */
    public String makeOutputLogForAnalyze(List<String> lines) {
//        String[] strLogArray = {"[200][http://apis.dktechin.net/search/knowledge?apikey=23jf&q=dktechin][IE][2019-06-10 08:00:00]"
//                ,"[200][http://apis.dktechin.net/search/knowledge?apikey=dcj8&q=dktechin][IE][2019-06-10 08:00:01]"
//                ,"[200][http://apis.dktechin.net/search/blog?apikey=wejf&q=dktechin][IE][2019-06-10 08:00:02]"
//                ,"[200][http://apis.dktechin.net/search/knowledge?apikey=e3ea&q=dktechin][IE][2019-06-10 08:00:03]"
//                ,"[200][http://apis.dktechin.net/search/vclip?apikey=2jdc&q=dktechin][IE][2019-06-10 08:00:04]"};
//        Iterator<String> strLogItr = Arrays.asList(strLogArray).iterator();

        if(lines == null) return "";
        Iterator<String> strLogItr = lines.iterator();
        // 집계 결과를 저장할 맵
        Map<String,Integer> countWebBrowserMap = new HashMap<>();
        Map<String,Integer> countApiServiceIdMap = new HashMap<>();
        Map<String,Integer> countApiKeyMap = new HashMap<>();

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

        // output.log에 저장할 문자열 생성합니다.
        StringBuilder sb = new StringBuilder();
        sb.append(getApikeyResult(countApiKeyMap)).append("\n");
        sb.append(getApiServiceIdResult(countApiServiceIdMap)).append("\n");
        sb.append(getWebBrowserResult(countWebBrowserMap));

        //System.out.println(sb);
        return sb.toString();
    }

    /**
     * 웹브라우저별 사용비율
     * @param countWebBrowserMap
     * @return
     */
    String getWebBrowserResult(Map<String,Integer> countWebBrowserMap) {
        int totalCount = countWebBrowserMap.values().stream().reduce(0, Integer::sum);
        String retStr = "웹브라우저별 사용비율 \n";
        for(Map<String,Integer> rankedMap : sortDescTotalList(countWebBrowserMap,countWebBrowserMap.keySet().size())) {
            for(String key : rankedMap.keySet()) {
                retStr += key +" : "+ Math.round(100.0 * countWebBrowserMap.get(key) / totalCount) + "%\n";
            }
        }
        return retStr;
    }

    /**
     * 상위 3개의 API ServiceID와 각각의 요청 수
     * @param countApiServiceIdMap
     * @return
     */
    String getApiServiceIdResult(Map<String,Integer> countApiServiceIdMap) {
        String retStr = "상위 3개의 API ServiceID와 각각의 요청 수 \n";
        for(Map<String,Integer> rankedMap : sortDescTotalList(countApiServiceIdMap, 3)) {
            for(String key : rankedMap.keySet()) {
                retStr += key +" : "+ rankedMap.get(key)  + "\n";
            }
        }
        return retStr;
    }

    /**
     * 최대 호출 APIKEY
     * @param countApiKeyMap
     * @return
     */
    String getApikeyResult(Map<String,Integer> countApiKeyMap) {
        return sortDescTotalList(countApiKeyMap,countApiKeyMap.keySet().size()).get(0).keySet()
                .stream()
                .map(key->"최대 호출 APIKEY\n" + key+"\n")
                .findFirst().get();
    }

    /**
     * 집계결과 맵을 파라미터로 받아서 내림차순 정렬된 리스트로 반환합니다.
     * @param totalMap
     * @param size
     * @return
     */
    List<Map<String,Integer>> sortDescTotalList(Map<String,Integer> totalMap, int size) {
        List<Map<String,Integer>> retList = new ArrayList<>();
        Map<String,Integer> retMap = null;

        for(int i=0;i<size;i++) {
            String maxKey = "";
            int maxCount = 0;
            boolean isContinue = false;

            for(String key : totalMap.keySet()) {
                for(Map<String,Integer> tempData : retList) {
                    if(tempData.containsKey(key)) isContinue = true;
                }

                if(isContinue) {
                    isContinue = false;
                    continue;
                }

                if(maxCount < totalMap.get(key)) {
                    maxKey = key;
                    maxCount = totalMap.get(key);
                }
            }
            retMap = new HashMap<String,Integer>();
            retMap.put(maxKey, maxCount);
            retList.add(retMap);
        }
        return retList;
    }

    /**
     * 집계결과 맵을 파라미터로 받아서 키워드를 키, 카운트를 벨류로 가지도록 처리합니다.
     * @param logResultMap
     * @param key
     */
    void countValue(Map<String, Integer> logResultMap, String key) {
        if(logResultMap.get(key) == null) {
            logResultMap.put(key,1);
        } else {
            logResultMap.put(key,logResultMap.get(key)+1);
        }
    }

}
