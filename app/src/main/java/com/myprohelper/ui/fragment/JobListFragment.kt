package com.myprohelper.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.myprohelper.R
import com.myprohelper.Toast
import com.myprohelper.adapter.JobListAdapter
import com.myprohelper.database.dao.JobListDAO
import com.myprohelper.database.AppDatabase
import com.myprohelper.entity.JobListEntityOrginal
import com.myprohelper.ui.activity.CreateJobActivity
import com.myprohelper.ui.activity.HomeActivity
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class JobListFragment : Fragment(), View.OnClickListener {
    private var mManager: FragmentManager? = null
    var jobListAdapter: JobListAdapter? = null
    var linearLayoutManager: LinearLayoutManager? = null
    private var appDatabase: AppDatabase? = null
    private var jobListDao: JobListDAO? = null
    var jobList: List<JobListEntityOrginal> = ArrayList()
    var rv_jobList: RecyclerView? = null
    //  var toolbar_main: Toolbar?= null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
        setOnClickListener()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_joblist, container, false)

        //  toolbar_main = activity!!.findViewById(R.id.toolbar_main)

        rv_jobList = view.findViewById(R.id.rv_jobList) as RecyclerView
        linearLayoutManager = LinearLayoutManager(activity!!)
        rv_jobList!!.layoutManager = linearLayoutManager


        var jobListDao = AppDatabase.getDatabase(activity!!)?.jobListDao()
        try {
            GlobalScope.launch {
                if (jobListDao?.getAllJobList()!!.size > 0) {
                    jobList = jobListDao?.getAllJobList()!!
                    Log.e("", "mysize" + jobList.size)

                    Thread(Runnable {

                        // try to touch View of UI thread
                        activity!!.runOnUiThread(java.lang.Runnable {
                            jobListAdapter = JobListAdapter(activity!!, jobList);
                            rv_jobList!!.adapter = jobListAdapter
//                            jobListAdapter?.notifyDataSetChanged()
                        })

                    }).start()
                } else {
                    //activity!!.Toast("no data found")
                }

            }

        } catch (e: Exception) {
            activity!!.Toast(" Exception :  " + e)
        }

        return view;
    }


    private fun setOnClickListener() {
        iv_add.setOnClickListener(this)
    }

    private fun initViews() {

        (activity as HomeActivity).setToolbarBackVisibility(true)


        var toolbar_main = activity?.findViewById<Toolbar>(R.id.toolbar_main)
        var toolbarTitleLeft = activity?.findViewById<TextView>(R.id.toolbarTitleLeft)
        var iv_toolbarMenu = activity?.findViewById<ImageView>(R.id.iv_toolbarMenu)
        var iv_toolbarBack = activity?.findViewById<ImageView>(R.id.iv_toolbarBack)
        var toolbarTitle = activity?.findViewById<TextView>(R.id.toolbarTitle)
        var iv_plus_icon = activity?.findViewById<ImageView>(R.id.iv_plus_icon)
        var iv_add_view_to_dashboard =
            activity?.findViewById<ImageView>(R.id.iv_add_view_to_dashboard)

        //   toolbar_main!!.setBackgroundColor(activity!!.resources.getColor(R.color.colorBlue))

        toolbar_main!!.visibility = View.GONE
        iv_toolbarBack!!.visibility = View.GONE

//        toolbarTitleLeft!!.visibility = View.VISIBLE
//        toolbarTitleLeft!!.text = "Job List"
//
//
//        iv_toolbarMenu!!.visibility =View.GONE
//        toolbarTitle!!.visibility = View.GONE
//        iv_plus_icon!!.visibility = View.GONE
//        iv_add_view_to_dashboard!!.visibility = View.VISIBLE
//        iv_add_view_to_dashboard!!.setImageResource(R.drawable.plus_icon_with_circle)
//        iv_toolbarBack!!.visibility = View.VISIBLE


    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_add -> {
                val intent = Intent(activity, CreateJobActivity::class.java)
                startActivity(intent)
            }

            R.id.iv_toolbarBack -> {

            }

        }
    }


}