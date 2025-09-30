package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskListViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;

    private final MutableLiveData<List<TaskModel>> _list = new MutableLiveData<>();
    public LiveData<List<TaskModel>> list = _list;

    private final MutableLiveData<Feedback> _feedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = _feedback;

    public TaskListViewModel(@NonNull Application application) {
        super(application);
        this.taskRepository = new TaskRepository(application);
    }

    public void list(int filter) {

        APIListener<List<TaskModel>> listener = new APIListener<List<TaskModel>>() {
            @Override
            public void onSuccess(List<TaskModel> result) {
                _list.setValue(result);
            }

            @Override
            public void onFailure(String message) {
                _list.setValue(new ArrayList<TaskModel>());
                _feedback.setValue(new Feedback(message));
            }
        };

        if (filter == TaskConstants.TASKFILTER.NO_FILTER) {
            this.taskRepository.all(listener);
        } else if (filter == TaskConstants.TASKFILTER.NEXT_7_DAYS) {
            this.taskRepository.nextWeek(listener);
        } else {
            this.taskRepository.overdue(listener);
        }
    }

    public void delete(int id) {
        this.taskRepository.delete(id, new APIListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    _feedback.setValue(new Feedback());
                }
            }

            @Override
            public void onFailure(String message) {
                _feedback.setValue(new Feedback(message));
            }
        });
    }
}