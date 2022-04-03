package com.log.analyzer.test;

import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {
    /*
    * 로그 파일을 읽어들입니다.
    *
    * 반드시 파일 I/O 처리를 해야 합니다.
    * 입력은 다음과 같은 형식의 input.log 파일로 전달되어야 합니다.
    * [200][http://apis.dktechin.net/search/vclip?apikey=fwji&q=dktechin][IE][2019-06-10 08:01:29]
    *
    * */
    @Override
    public List<LogVO> logRead() {

        //1. 파일이 존재하지 않으면 리턴합니다. NoSuchFileException 발생하지 않게 합니다.
        File file = new File(logFilePath);
        if(!file.exists()) return null;

        try {
            /*
            * 자바 1.7 이후부터 java.noi.file 을 지원합니다.
            * 파일 읽어들이는 코드가 굉장히 간단합니다.
            * 한 줄이면 끝이고 리턴타입이 리스트 타입이라 스트림 API를 사용하기 편합니다. 해당 API를 사용하도록 하겠습니다.
            * IO Exception과 Security Exception이 발생할 수 있다고 합니다.
            * */
            List<String> strList = Files.readAllLines(Paths.get(logFilePath));

            List<LogVO> logList = strList.stream().map(s -> {
                String[] sp =  s.replaceAll("\\[","").split("\\]");
                //Arrays.asList(sp).stream().forEach(System.out::println); 문자열 변환 체크 완료
                LogVO log = new LogVO();
                log.setStatusCode(sp[0]);   //상태코드
                log.setUrl(sp[1]);          //URL

                String[] url = sp[1].split("\\/");
                String tempServiceId = url[url.length - 1];

                log.setApiServiceId(tempServiceId.split("\\?")[0]);

                if(tempServiceId.split("\\?")[1] != null){
                    String[] params = tempServiceId.split("\\?")[1].split("&");

                    if(params[0] != null) log.setApiKey(params[0]);
                    if(params[1] != null) log.setApiQ(params[1]);
                }

                log.setWebBrowser(sp[2]);   //브라우저
                log.setStrCreateDate(sp[3]);//호출시간
                return log;
            }).collect(Collectors.toList());

            //결과
            //logList.stream().forEach(item-> System.out.println(item.toString()));

            return logList;
        }
        catch(IOException ioe) {
            System.out.println("IOE 에러가 발생했습니다.");
            ioe.printStackTrace();
        }
        catch(SecurityException se) {
            System.out.println("SE 에러가 발생했습니다.");
        }
        catch (Exception e) {
            System.out.println("E 에러가 발생했습니다.");
        }

        return null;
    }

    @Override
    public Map<String, String> logProcessor(List<LogVO> logVOList) {
        System.out.println("size: "+ logVOList.size());

        logVOList.stream().forEach(vo-> System.out.println(vo.toStringURL()));

        return null;
    }

    @Override
    public boolean logWrite(List<LogVO> logVOList) {

        String outputFileName = "output_"+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + ".log";
        String outputLogPath = logPath + "/" + outputFileName;

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
}
