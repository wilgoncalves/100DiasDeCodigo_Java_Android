package com.devmasterteam.tasks.service.repository;

import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.repository.remote.PriorityService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriorityRepository {

    private PriorityService priorityService;

    public PriorityRepository() {
        this.priorityService = RetrofitClient.createService(PriorityService.class);
    }

    public void all(APIListener<List<PriorityModel>> listener) {
        Call<List<PriorityModel>> call = this.priorityService.all();
        call.enqueue(new Callback<List<PriorityModel>>() {
            @Override
            public void onResponse(Call<List<PriorityModel>> call, Response<List<PriorityModel>> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<PriorityModel>> call, Throwable t) {

            }
        });
    }
}
