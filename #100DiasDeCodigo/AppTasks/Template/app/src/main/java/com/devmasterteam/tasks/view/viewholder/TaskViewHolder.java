package com.devmasterteam.tasks.view.viewholder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

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

        this.binding.textDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onListClick(task.getId());
            }
        });

        this.binding.textDescription.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                new AlertDialog.Builder(itemView.getContext())
                        .setTitle(R.string.title_task_removal)
                        .setMessage(R.string.label_remove_task)
                        .setPositiveButton(R.string.button_yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listener.onDeleteClick(task.getId());
                            }
                        }).setNeutralButton(R.string.button_cancel, null).show();
                return false;
            }
        });
    }
}