package com.example.constructdemo.net;

public interface IRequestApi<ResultType> {
    ResultType getBody();
    String getErrorMsg();
    boolean isSuccessful();
}
