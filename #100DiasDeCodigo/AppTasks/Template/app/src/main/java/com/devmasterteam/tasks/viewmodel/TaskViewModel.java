package com.devmasterteam.tasks.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.PriorityRepository;
import com.devmasterteam.tasks.service.repository.TaskRepository;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private PriorityRepository priorityRepository;
    private TaskRepository taskRepository;

    private MutableLiveData<List<PriorityModel>> mListPriority = new MutableLiveData<>();
    public LiveData<List<PriorityModel>> listPriority = this.mListPriority;

    private MutableLiveData<TaskModel> mTaskLoad = new MutableLiveData<>();
    public LiveData<TaskModel> taskLoad = this.mTaskLoad;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;

    public TaskViewModel(@NonNull Application application) {
        super(application);
        this.priorityRepository = new PriorityRepository(application);
        this.taskRepository = new TaskRepository(application);
    }

    public void getList() {
        List<PriorityModel> list = this.priorityRepository.getList();
        this.mListPriority.setValue(list);
    }

    public void load(int id) {
        this.taskRepository.load(id, new APIListener<TaskModel>() {
            @Override
            public void onSuccess(TaskModel result) {
                mTaskLoad.setValue(result);
            }

            @Override
            public void onFailure(String message) {
                mFeedback.setValue(new Feedback(message));
            }
        });
    }

    public void save(TaskModel task) {

        if (task.getId() == 0) {
            this.taskRepository.create(task, new APIListener<Boolean>() {
                @Override
                public void onSuccess(Boolean result) {
                    mFeedback.setValue(new Feedback());
                }

                @Override
                public void onFailure(String message) {
                    mFeedback.setValue(new Feedback(message));
                }
            });
        }
    }
}