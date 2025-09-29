package com.devmasterteam.tasks.view.viewholder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devmasterteam.tasks.R;
import com.devmasterteam.tasks.databinding.ItemTaskBinding;
import com.devmasterteam.tasks.service.listener.TaskListener;
import com.devmasterteam.tasks.service.model.TaskModel;
import com.devmasterteam.tasks.service.repository.PriorityRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskViewHolder extends RecyclerView.ViewHolder {

    private final TaskListener listener;
    private final ItemTaskBinding binding;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private PriorityRepository priorityRepository;

    public TaskViewHolder(@NonNull ItemTaskBinding item, TaskListener listener) {
        super(item.getRoot());
        this.binding = item;
        this.listener = listener;
        this.priorityRepository = new PriorityRepository(item.getRoot().getContext());
    }

    /**
     * Atribui valores aos elementos de interface e também eventos
     */
    public void bindData(final TaskModel task) {

        this.binding.textDescription.setText(task.getDescription());

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(task.getDueDate());
            this.binding.textDuedate.setText(this.dateFormat.format(date));
        } catch (ParseException e) {
            this.binding.textDuedate.setText("--");
        }

        String priority = this.priorityRepository.getDescription(task.getPriorityId());
        this.binding.textPriority.setText(priority);

        if (task.getComplete()) {
            this.binding.imageComplete.setImageResource(R.drawable.ic_done);
        } else {
            this.binding.imageComplete.setImageResource(R.drawable.ic_todo);
        }
    }
}