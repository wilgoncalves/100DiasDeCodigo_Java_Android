package com.devmasterteam.tasks.service.repository;

import android.content.Context;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.listener.APIListener;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.service.repository.local.PriorityDAO;
import com.devmasterteam.tasks.service.repository.local.TaskDatabase;
import com.devmasterteam.tasks.service.repository.remote.PriorityService;
import com.devmasterteam.tasks.service.repository.remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PriorityRepository extends BaseRepository {

    private PriorityService priorityService;
    private PriorityDAO priorityDAO;

    public PriorityRepository(Context context) {
        super(context);
        this.context = context;
        this.priorityService = RetrofitClient.createService(PriorityService.class);
        this.priorityDAO = TaskDatabase.getDataBase(context).priorityDAO();
    }

    public void all(APIListener<List<PriorityModel>> listener) {
        Call<List<PriorityModel>> call = this.priorityService.all();
        call.enqueue(new Callback<List<PriorityModel>>() {
            @Override
            public void onResponse(Call<List<PriorityModel>> call, Response<List<PriorityModel>> response) {
                if (response.code() == TaskConstants.HTTP.SUCCESS) {
                    listener.onSuccess(response.body());
                } else {
                    listener.onFailure(handleFailure(response.errorBody()));
                }
            }

            @Override
            public void onFailure(Call<List<PriorityModel>> call, Throwable t) {
                listener.onFailure(context.getString(R.string.error_unexpected));
            }
        });
    }

    public List<PriorityModel> getList() {
        return this.priorityDAO.list();
    }

    public String getDescription(int id) {
        return this.priorityDAO.getDescription(id);
    }

    public void save(List<PriorityModel> list) {
        this.priorityDAO.clear();
        this.priorityDAO.save(list);
    }
}
