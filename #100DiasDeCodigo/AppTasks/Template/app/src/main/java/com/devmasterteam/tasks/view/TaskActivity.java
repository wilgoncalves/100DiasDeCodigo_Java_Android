package com.devmasterteam.tasks.view;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ActivityTaskBinding;
import com.devmasterteam.tasks.service.listener.Feedback;
import com.devmasterteam.tasks.service.model.PriorityModel;
import com.devmasterteam.tasks.viewmodel.TaskViewModel;
import com.devmasterteam.tasks.service.constants.TaskConstants;
import com.devmasterteam.tasks.service.model.TaskModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private TaskViewModel viewModel;
    private List<Integer> listPriorityId = new ArrayList<>();
    private int taskId = 0;
    private ActivityTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Botão voltar nativo
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left + binding.getRoot().getPaddingStart(),
                    systemBars.top + binding.getRoot().getPaddingTop(),
                    systemBars.right + binding.getRoot().getPaddingEnd(),
                    systemBars.bottom + binding.getRoot().getPaddingBottom());
            return insets;
        });

        // ViewModel
        viewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        createEvents();

        // Cria observadores
        loadObservers();

        // Listagem de tarefas
        viewModel.getList();

        // Carrega parâmetros passados na chamada da Activity
        loadDataFromActivity();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.button_date) {
            this.showDatePicker();
        } else if (id == R.id.button_save) {
            this.handleSave();
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth);

        String date = this.format.format(calendar.getTime());
        this.binding.buttonDate.setText(date);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    private void loadDataFromActivity() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            taskId = bundle.getInt(TaskConstants.BUNDLE.TASKID);
            binding.buttonSave.setText(this.getString(R.string.button_update_task));
            viewModel.load(taskId);
        }
    }

    private void handleSave() {
        TaskModel task = new TaskModel();

        // Testando:
        task.setDescription(this.binding.editDescription.getText().toString());
        task.setComplete(this.binding.checkComplete.isChecked());
        task.setDueDate(this.binding.buttonDate.getText().toString());
        //
        task.setPriorityId(this.listPriorityId.get(this.binding.spinnerPriority.getSelectedItemPosition()));
        viewModel.save(task);
    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        new DatePickerDialog(this, this, year, month, day).show();
    }

    /**
     * Observadores
     */
    private void loadObservers() {
        this.viewModel.listPriority.observe(this, new Observer<List<PriorityModel>>() {
            @Override
            public void onChanged(List<PriorityModel> list) {
                loadSpinner(list);
            }
        });

        this.viewModel.taskSave.observe(this, new Observer<Feedback>() {
            @Override
            public void onChanged(Feedback feedback) {
                String s = "";
            }
        });
    }

    private void loadSpinner(List<PriorityModel> list) {

        List<String> listPriorities = new ArrayList<>();
        for (PriorityModel p : list) {
            listPriorities.add(p.getDescription());
            this.listPriorityId.add(p.getId());
        }

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item, listPriorities);
        this.binding.spinnerPriority.setAdapter(adapter);
    }

    private void createEvents() {
        binding.buttonDate.setOnClickListener(this);
        binding.buttonSave.setOnClickListener(this);
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}