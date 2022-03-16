package com.example.java8to11.vo;

import java.util.Optional;

public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;

    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    /**
     * 자바8 이후 옵셔널 사용
     * 리턴 값으로만 사용하기를 권장한다.
     * Optional.of() => null이 나오지 않는 값에 사용 null일 경우 nullPointException
     */
    public Optional<Progress> getProgress() {

        //자바8 이전에 해결방법
//        if(this.progress == null) {
//            throw new IllegalStateException();
//        }
        return Optional.ofNullable(progress);
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
    }
}
