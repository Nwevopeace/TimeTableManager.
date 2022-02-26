package com.peacecodes.timetablemanager.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.peacecodes.timetablemanager.adapters.RecyclerAdapter
import com.peacecodes.timetablemanager.databinding.FragmentMondayBinding
import com.peacecodes.timetablemanager.db.TimeTableDbHelper

class MondayFragment : Fragment() {
    private lateinit var bind: FragmentMondayBinding
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        bind = FragmentMondayBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutManager = LinearLayoutManager(activity)
        adapter = RecyclerAdapter(TimeTableDbHelper(requireContext()).getDayTimeTable("Monday"))
        bind.recyclerView.layoutManager = layoutManager
        bind.recyclerView.adapter = adapter

    }

}