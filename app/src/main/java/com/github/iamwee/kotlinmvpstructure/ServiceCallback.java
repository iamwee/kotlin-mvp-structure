package com.github.iamwee.kotlinmvpstructure;

import retrofit2.Call;


public interface ServiceCallback<T> {

    void onResponse(Call<T> call, T body);

    void onFailure(Call<T> call, Throwable t);
}
