package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;
import com.devmasterteam.tasks.service.repository.remote.TaskService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TaskRepository extends BaseRepository {

    private final TaskService taskService;

    public TaskRepository(Context context) {
        super(context);
        this.taskService = RetrofitClient.createService(TaskService.class);
    }

    private void save(Call<Boolean> call, final APIListener<Boolean> listener) {
        call.enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(@NonNull Call<Boolean> call, @NonNull Response<Boolean> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Boolean> call, @NonNull Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }
    public void create(TaskModel taskModel, final APIListener<Boolean> listener) {
        Call<Boolean> call = taskService.create(
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.getComplete()
        );
        this.save(call, listener);
    }

    public void update(TaskModel taskModel, final APIListener<Boolean> listener) {
        Call<Boolean> call = taskService.update(
                taskModel.getId(),
                taskModel.getPriorityId(),
                taskModel.getDescription(),
                taskModel.getDueDate(),
                taskModel.getComplete()
        );
        this.save(call, listener);
    }

    private void list(Call<List<TaskModel>> call, final APIListener<List<TaskModel>> listener) {
        call.enqueue(new Callback<List<TaskModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<TaskModel>> call, @NonNull Response<List<TaskModel>> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<TaskModel>> call, @NonNull Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }

    public void all(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.taskService.all();
        this.list(call, listener);
    }

    public void nextWeek(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.taskService.nextWeek();
        this.list(call, listener);
    }

    public void overdue(final APIListener<List<TaskModel>> listener) {
        Call<List<TaskModel>> call = this.taskService.overdue();
        this.list(call, listener);
    }

    public void load(int id, final APIListener<TaskModel> listener) {
        Call<TaskModel> call = this.taskService.load(id);
        call.enqueue(new Callback<TaskModel>() {
            @Override
            public void onResponse(Call<TaskModel> call, Response<TaskModel> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<TaskModel> call, Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }
}
