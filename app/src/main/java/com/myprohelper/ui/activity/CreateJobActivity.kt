package com.myprohelper.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.room.ColumnInfo
import com.myprohelper.R
import com.myprohelper.Toast
import com.myprohelper.database.AppDatabase
import com.myprohelper.entity.JobListEntityOrginal
import kotlinx.android.synthetic.main.activity_create_job.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateJobActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_job)

        initViews()
        setOnClickListener()
    }


    private fun setOnClickListener() {
        iv_back.setOnClickListener(this)
        iv_add.setOnClickListener(this)
    }


    private fun initViews() {
        tv_toolbar.setText(resources.getString(R.string.menu_job_list))
        tv_toolbar.setBackgroundColor(resources.getColor(R.color.colorBlue))

        toolbarTitle.text = "Create Job"
        iv_add.setImageResource(R.drawable.plus_icon_with_circle)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_back -> {
                finish()
            }
            R.id.iv_add -> {
                createJob()
            }
        }
    }

    private fun createJob() {
        var jobTitle = ed_job_title.text.toString()
        var issue = tv_enter_issue.text.toString()
        var name = ed_name.text.toString()
        var phoneNumber = ed_phone.text.toString()
        var emailId = ed_emailID.text.toString()
        var address_1 = ed_address_1.text.toString()
        var address_2 = ed_address_2.text.toString()
        var city = ed_city.text.toString()
        var state = ed_state.text.toString()
        var zip = ed_zip.text.toString()
        var selected_workerName = tv_select_worker.text.toString()
        var selected_date_time = tv_select_date_time.text.toString()
        var selected_job_status = tv_select_job_status.text.toString()
        var selected_attachments = tv_select_attachments.text.toString()

//        val JobID: Int,
//        val CustomerID: Int,
//        @ColumnInfo(name = "JobLocationAddress1") val jobLocationAddress1: String?,
//        @ColumnInfo(name = "JobLocationAddress2") val jobLocationAddress2: String?,
//        @ColumnInfo(name = "JobLocationCity") val jobLocationCity: String?,
//        @ColumnInfo(name = "JobLocationState") val jobLocationState: String?,
//        @ColumnInfo(name = "JobLocationZip") val jobLocationZip: String?,
//        @ColumnInfo(name = "JobContactPersonName") val jobContactPersonName: String?,
//        @ColumnInfo(name = "JobContactPhone") val jobContactPhone: String?,
//        @ColumnInfo(name = "JobContactEmail") val jobContactEmail: String?,
//        @ColumnInfo(name = "JobShortDescription") val jobShortDescription: String?,
//        @ColumnInfo(name = "JobDescription") val jobDescription: String?,
//        @ColumnInfo(name = "DateTimeScheduled") val dateTimeScheduled: String?,
//        @ColumnInfo(name = "WorkerID") val workerID: String?,
//        @ColumnInfo(name = "JobStatus") val jobStatus: String?,
//        @ColumnInfo(name = "SampleScheduledJob") val sampleScheduledJob: String?,
//        @ColumnInfo(name = "Removed") val removed: String?,
//        @ColumnInfo(name = "RemovedDate") val removedDate: String?,
//        @ColumnInfo(name = "NumberOfAttachments") val numberOfAttachments: String?


        var request = JobListEntityOrginal(
            CustomerID = 1,
            jobLocationAddress1 = "Noida Address 1",
            jobLocationAddress2 = "Gurgaon Address 2",
            jobLocationCity = "City qwerty",
            jobLocationState = "state Up",
            jobLocationZip = "zip 63",
            jobContactPersonName = "Pallavi",
            jobContactPhone = "12345 phone",
            jobContactEmail = "abc@gmail.com",
            jobShortDescription = "short descp",
            jobDescription = "job descp",
            dateTimeScheduled = "date time",
            workerID = "worker id",
            jobStatus = "job status",
            sampleScheduledJob = "scheduled job",
            removed = "removed",
            removedDate = "remove date",
            numberOfAttachments = "numberOfAttachments 1"
        )

        var jobListDoa = AppDatabase.getDatabase(this)?.jobListDao()
        try {
            GlobalScope.launch { jobListDoa?.insertAll(request) }
            this.Toast(" Data saved successfully")

        } catch (e: Exception) {
        }


    }


}