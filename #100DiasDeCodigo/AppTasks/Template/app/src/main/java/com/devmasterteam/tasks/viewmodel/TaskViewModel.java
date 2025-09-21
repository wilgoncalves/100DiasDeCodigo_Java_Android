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

    private MutableLiveData<Feedback> mTaskSave = new MutableLiveData<>();
    public LiveData<Feedback> taskSave = this.mTaskSave;

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
    }

    public void save(TaskModel task) {
        this.taskRepository.save(task, new APIListener<Boolean>() {
            @Override
            public void onSuccess(Boolean result) {
                mTaskSave.setValue(new Feedback());
            }

            @Override
            public void onFailure(String message) {
                mTaskSave.setValue(new Feedback(message));
            }
        });
    }
}