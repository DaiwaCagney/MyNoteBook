package com.example.mynotebook

import androidx.lifecycle.*
import com.example.mynotebook.database.Task
import com.example.mynotebook.database.TaskDao
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {

    val allItems: LiveData<List<Task>> = taskDao.getItems().asLiveData()

    private fun insertItem(task: Task) {
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }

    private fun getNewItemEntry(taskName: String, taskContent: String): Task {
        return Task(
            taskName = taskName,
            taskContent = taskContent
        )
    }

    fun addNewItem(taskName: String, taskContent: String) {
        val newItem = getNewItemEntry(taskName, taskContent)
        insertItem(newItem)
    }

    fun deleteItem(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }

    fun retrieveItem(id: Int): LiveData<Task> {
        return taskDao.getItem(id).asLiveData()
    }

    fun isEntryValid(taskName: String, taskContent: String): Boolean {
        if (taskName.isBlank() || taskContent.isBlank()) {
            return false
        }
        return true
    }
}

class TaskViewModelFactory(private val taskDao: TaskDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TaskViewModel(taskDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}