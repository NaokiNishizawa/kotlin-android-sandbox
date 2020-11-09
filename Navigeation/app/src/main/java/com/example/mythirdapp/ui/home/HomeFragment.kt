package com.example.mythirdapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mythirdapp.AppViewModel
import com.example.mythirdapp.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        val btn : Button = root.findViewById(R.id.button_go_dashboard)
        btn.setOnClickListener { view ->
            this.appViewModel.data.value = "This is HomeFragment-Data!!!"
            view.findNavController().navigate(
                R.id.action_navigation_home_to_navigation_dashboard
            )
        }

        val btn2 : Button = root.findViewById(R.id.button_go_notification)
        btn2.setOnClickListener { view ->
            // Argment Linkを使用した値の受け渡し方法　設定処理
            var bundle = bundleOf("msg" to "from Home with Love!")
            view.findNavController().navigate(
                R.id.action_navigation_home_to_navigation_notifications,
                bundle
            )
        }
        return root
    }
}