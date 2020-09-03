package com.myprohelper.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class JobListEntityOrginal(
    @PrimaryKey(autoGenerate = true)
    val JobID: Int = 0,
    val CustomerID: Int,
    @ColumnInfo(name = "JobLocationAddress1") val jobLocationAddress1: String?,
    @ColumnInfo(name = "JobLocationAddress2") val jobLocationAddress2: String?,
    @ColumnInfo(name = "JobLocationCity") val jobLocationCity: String?,
    @ColumnInfo(name = "JobLocationState") val jobLocationState: String?,
    @ColumnInfo(name = "JobLocationZip") val jobLocationZip: String?,
    @ColumnInfo(name = "JobContactPersonName") val jobContactPersonName: String?,
    @ColumnInfo(name = "JobContactPhone") val jobContactPhone: String?,
    @ColumnInfo(name = "JobContactEmail") val jobContactEmail: String?,
    @ColumnInfo(name = "JobShortDescription") val jobShortDescription: String?,
    @ColumnInfo(name = "JobDescription") val jobDescription: String?,
    @ColumnInfo(name = "DateTimeScheduled") val dateTimeScheduled: String?,
    @ColumnInfo(name = "WorkerID") val workerID: String?,
    @ColumnInfo(name = "JobStatus") val jobStatus: String?,
    @ColumnInfo(name = "SampleScheduledJob") val sampleScheduledJob: String?,
    @ColumnInfo(name = "Removed") val removed: String?,
    @ColumnInfo(name = "RemovedDate") val removedDate: String?,
    @ColumnInfo(name = "NumberOfAttachments") val numberOfAttachments: String?

)