package com.example.mythirdapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mythirdapp.AppViewModel
import com.example.mythirdapp.R

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        dashboardViewModel.text.value = "data:" + appViewModel.data.value
        Toast.makeText(this.context, "data:" + appViewModel.data.value, Toast.LENGTH_LONG).show()

        return root
    }
}