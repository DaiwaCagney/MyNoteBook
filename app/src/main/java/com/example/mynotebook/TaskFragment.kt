package com.example.mynotebook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotebook.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {

    private val viewModel: TaskViewModel by activityViewModels {
        TaskViewModelFactory(
            (activity?.application as NotesApplication).database.taskDao()
        )
    }

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TaskAdapter {
            val action =
                TaskFragmentDirections.actionTaskFragmentToTaskDetailFragment(it.id)
            this.findNavController().navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter

        viewModel.allItems.observe(viewLifecycleOwner) { tasks ->
            tasks.let {
                adapter.submitList(it)
            }

        }


        binding.floatingActionButton.setOnClickListener {
            val action = TaskFragmentDirections.actionTaskFragmentToAddTaskFragment()
            this.findNavController().navigate(action)
        }
    }
}