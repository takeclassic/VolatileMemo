package com.thinkers.volatilememo.memo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.SearchView

import com.thinkers.volatilememo.MainActivity
import com.thinkers.volatilememo.R
import java.text.DateFormat

import java.util.*

class MemoFragment : Fragment() {

    companion object {
        fun newInstance() = MemoFragment()
    }

    private lateinit var viewModel: MemoViewModel
    private lateinit var toolBarSearchView: SearchView
    private lateinit var toolBarTitle: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.memo_fragment, container, false)

        toolBarSearchView = (activity as MainActivity).findViewById(R.id.toolbar_search)
        toolBarSearchView.visibility = View.GONE

        toolBarTitle = (activity as MainActivity).findViewById(R.id.toolbar_title)

        val dateFormat = DateFormat.getDateTimeInstance()
        val date = dateFormat.format(Date())
        toolBarTitle.text = date
        toolBarTitle.textSize = 10F
        toolBarTitle.visibility = View.VISIBLE

        return root
    }

    override fun onStop() {
        super.onStop()
        toolBarSearchView.visibility = View.VISIBLE
        toolBarTitle.visibility = View.GONE
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MemoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}