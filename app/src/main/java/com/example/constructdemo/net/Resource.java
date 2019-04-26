package com.example.constructdemo.net;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.example.constructdemo.net.ResponseStatus.ERROR;
import static com.example.constructdemo.net.ResponseStatus.LOADING;
import static com.example.constructdemo.net.ResponseStatus.MORE_ADD;
import static com.example.constructdemo.net.ResponseStatus.SUCCEED;

public class Resource<T> {

    @NonNull
    public final ResponseStatus status;
    @Nullable
    public final T data;
    @Nullable
    public final String message;

    private Resource(@NonNull ResponseStatus status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(SUCCEED, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    public static <T> Resource<T> moreSucceed(@Nullable T data) {
        return new Resource<>(MORE_ADD, data, null);
    }

}

