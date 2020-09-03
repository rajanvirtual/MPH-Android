package com.myprohelper.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.myprohelper.R
import com.myprohelper.entity.JobListEntityOrginal


class JobListAdapter(var mContext: Context, var jobList: List<JobListEntityOrginal>) :
    RecyclerView.Adapter<JobListAdapter.JobListViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): JobListAdapter.JobListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_list_joblist, parent, false)
        return JobListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return jobList.size
    }

    override fun onBindViewHolder(holder: JobListAdapter.JobListViewHolder, position: Int) {
        var dataList = jobList.get(position)
        holder.bindData(dataList)
    }


    class JobListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_jobID: TextView
        var tv_description: TextView
        var tv_emailId: TextView
        var tv_phoneNumber: TextView
        var tv_Date: TextView
        var tv_start_completed_status: TextView


        init {
            tv_jobID = itemView.findViewById(R.id.tv_jobID)
            tv_description = itemView.findViewById(R.id.tv_description)
            tv_emailId = itemView.findViewById(R.id.tv_emailId)
            tv_phoneNumber = itemView.findViewById(R.id.tv_phoneNumber)
            tv_Date = itemView.findViewById(R.id.tv_Date)
            tv_start_completed_status = itemView.findViewById(R.id.tv_Date)
        }

        fun bindData(dataModel: JobListEntityOrginal) {
            tv_jobID.setText("" + dataModel.JobID)
            tv_emailId.setText(dataModel.jobContactEmail)
            tv_phoneNumber.setText(dataModel.jobContactPhone)
            tv_Date.setText(dataModel.dateTimeScheduled)

        }


    }


}