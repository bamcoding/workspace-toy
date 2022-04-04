package com.log.analyzer.test;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {

    private String[] WebBrowser = {"ie","firefox","safari","chrome","opera"};

    @Override
    public List<LogVO> logRead() {
        long startTime = System.currentTimeMillis();

        if(!new File(inputLogPath).exists()) return null;

        try {
            List<String> lineList = Files.readAllLines(Paths.get(inputLogPath));
            List<LogVO> logVOList = lineList.stream().map(line->setLog(line)).collect(Collectors.toList());
            return logVOList;
        }
        catch (IOException e) {
            System.out.println("logRead IOException - " + e.getMessage());
        }
        finally {
            System.out.println("it take - " + (System.currentTimeMillis()-startTime)/1000.0 + "s");
        }

        return null;
    }

    @Override
    public Map<String, String> logProcessor(List<LogVO> logVOList) {

        if(logVOList == null || logVOList.size() == 0) return null;

        logVOList = logVOList.stream().filter(logVO -> logVO.getStatusCode().equals("200")).collect(Collectors.toList());

        System.out.println("size: "+ logVOList.size());

        //blog, book, image, knowledge, news, vclip 중 하나
        int blog = 0;
        int book = 0;
        int image = 0;
        int knowledge = 0;
        int news = 0;
        int vclip = 0;

        int ie = 0;
        int firefox = 0;
        int safari = 0;
        int chrome = 0;
        int opera = 0;

        for(LogVO logVO:logVOList) {
            switch (logVO.getApiServiceId().toLowerCase()) {
                case "blog":
                    blog++;
                    break;
                case "book":
                    book++;
                    break;
                case "image":
                    image++;
                    break;
                case "knowledge":
                    knowledge++;
                    break;
                case "news":
                    news++;
                    break;
                case "vclip":
                    vclip++;
                    break;
            }

            switch (logVO.getWebBrowser().toLowerCase()) {
                case "ie":
                    ie++;
                    break;
                case "firefox":
                    firefox++;
                    break;
                case "safari":
                    safari++;
                    break;
                case "chrome":
                    chrome++;
                    break;
                case "opera":
                    opera++;
                    break;
            }
        }

        System.out.println("blog = " + blog);
        System.out.println("book = " + book);
        System.out.println("image = " + image);
        System.out.println("knowledge = " + knowledge);
        System.out.println("news = " + news);
        System.out.println("vclip = " + vclip);


        System.out.println("ie = " + ie);
        System.out.println("firefox = " + firefox);
        System.out.println("firefox = " + safari);
        System.out.println("chrome = " + chrome);
        System.out.println("opera = " + opera);

        return null;
    }

    @Override
    public boolean logWrite(List<LogVO> logVOList) {

        try{
            //1. 파일이 있는지 확인하고 지웁니다.
            boolean isExist = Files.exists(Paths.get(outputLogPath));
            if(isExist) Files.delete(Paths.get(outputLogPath));

            //2. 새 파일을 생성합니다.
            OutputStream outputStream = Files.newOutputStream(Files.createFile(Paths.get(outputLogPath)));

            StringBuffer sb = new StringBuffer();
            logVOList.stream().forEach(vo->{
                sb.append(vo.toString()+"\n");
            });

            outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
            outputStream.flush();//바로 쓰기
            outputStream.close();//시스템 메모리 해방
            return true;

        } catch(IOException ioe) {
            System.out.println("logWrite에서 IOE 에러가 발생했습니다.");
        }

        return false;
    }

    private LogVO setLog(String line) {
        String[] sp =  line.replaceAll("\\[","").split("\\]");
        LogVO log = new LogVO();
        log.setStatusCode(sp[0]);   //상태코드
        log.setUrl(sp[1]);          //URL
        log.setWebBrowser(sp[2]);   //브라우저
        log.setStrCreateDate(sp[3]);//호출시간

        setApiParams(log);
        return log;
    }

    private void setApiParams(LogVO logVO) {
        String[] splitService = logVO.getUrl().split("\\/");
        String[] splitServiceId = splitService[splitService.length-1].split("\\?");

        logVO.setApiServiceId(splitServiceId[0]);

        String[] splitParams = splitServiceId[splitServiceId.length-1].split("&");
        Map<String,String> map = Arrays.asList(splitParams).stream()
                .collect(Collectors.toMap(
                        p1->p1.split("=")[0],
                        p2->p2.split("=")[1]
                ));

        logVO.setApiKey(map.get("apikey"));
        logVO.setApiQ(map.get("q"));
    }
}
