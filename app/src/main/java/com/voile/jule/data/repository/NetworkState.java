package com.voile.jule.data.repository;

enum Status{
    RUNNING,
    SUCCESS,
    FAILED
}


public class NetworkState {

    public static final NetworkState LOADED = new NetworkState(Status.SUCCESS,"success");
    public static final NetworkState LOADING = new NetworkState(Status.RUNNING,"running");
    public static final NetworkState ERROR = new NetworkState(Status.FAILED,"Something went wrong");
    public static final NetworkState EOF = new NetworkState(Status.FAILED,"You have reached the end");

    private Status status;
    private String msg;

    private NetworkState(Status status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}