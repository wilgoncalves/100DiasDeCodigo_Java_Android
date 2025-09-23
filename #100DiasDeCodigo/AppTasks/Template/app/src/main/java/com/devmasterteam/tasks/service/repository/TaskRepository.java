package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;
import com.devmasterteam.tasks.service.repository.remote.TaskService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository extends BaseRepository {

    private TaskService taskService;

    public TaskRepository(Context context) {
        super(context);
        this.taskService = RetrofitClient.createService(TaskService.class);
    }

    public void save(TaskModel taskModel, APIListener<Boolean> listener) {
        Call<Boolean> call = taskService.create(
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.getComplete()
        );
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }
}
