package com.myprohelper.database.dao

import androidx.room.*

import com.myprohelper.entity.JobListEntityOrginal

@Dao
interface JobListDAO {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertJobList(jobList: JobListEntityOrginal)

    @Insert
    fun insertAll(vararg jobList: JobListEntityOrginal)


    @Update
    fun updateJobList(jobList: JobListEntityOrginal)

    @Delete
    fun deleteJobList(jobList: JobListEntityOrginal)

    @Query("SELECT * FROM JobListEntityOrginal")
    fun getAllJobList(): List<JobListEntityOrginal>

    @Query("SELECT * FROM JobListEntityOrginal WHERE JobID IN (:jobIds)")
    fun loadAllByIds(jobIds: IntArray): List<JobListEntityOrginal>


    // Given by Rajan

/*
    @Query("SELECT * FROM user")
    fun getAll(): ArrayList<User>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): ArrayList<User>

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)*/


}
