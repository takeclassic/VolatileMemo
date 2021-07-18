package com.thinkers.volatilememo.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.thinkers.volatilememo.R

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var fab: FloatingActionButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.home_fragment, container, false)
        setHasOptionsMenu(true)

        fab = root.findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick(it)
        }
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //inflater.inflate(R.menu.sample_menu, menu)
    }

    private fun fabOnClick(view: View) {
        val action = HomeFragmentDirections.actionMenuHomeToMemoFragment()
        view.findNavController().navigate(action)
    }

}