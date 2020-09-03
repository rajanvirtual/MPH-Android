package com.myprohelper.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.myprohelper.R
import com.myprohelper.ui.fragment.AddWidgetsFragment
import com.myprohelper.ui.fragment.DashboardFragment
import com.myprohelper.ui.fragment.JobListFragment
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.app_bar_main.*


class HomeActivity : AppCompatActivity(), View.OnClickListener,
    NavigationView.OnNavigationItemSelectedListener {
    private var mDrawerLayout: DrawerLayout? = null
    private var mActionBarDrawerToggle: ActionBarDrawerToggle? = null
    private var mManager: FragmentManager? = null
    private var mTransaction: FragmentTransaction? = null
    private var mContext: Context? = null
    private var toolbar: Toolbar? = null
    private var profileImage: CircleImageView? = null
    private var profileName: TextView? = null
    private var profileEmailAddress: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        initView()
        setUpDrawerLayout()
        setUpClickListener()

    }

    private fun initView() {
        mContext = this@HomeActivity
        toolbar = findViewById<Toolbar>(R.id.toolbar_main)
        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        val headerLayout = navigationView.getHeaderView(0)
        profileImage = headerLayout.findViewById<View>(R.id.profile_img) as CircleImageView
        profileName = headerLayout.findViewById<View>(R.id.tv_profileName) as TextView
        profileEmailAddress = headerLayout.findViewById<View>(R.id.tv_emailAddress) as TextView


    }

    /**
     * Setup Drawer Layout
     */
    private fun setUpDrawerLayout() {
        mDrawerLayout = findViewById(R.id.drawer_layout) as DrawerLayout
        mActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        ) {
            override fun onDrawerClosed(drawerView: View) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView)
            }

            override fun onDrawerOpened(drawerView: View) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView)
            }
        }

        mDrawerLayout!!.setDrawerListener(mActionBarDrawerToggle)
    }

    /**
     * Setup clickListener
     */
    private fun setUpClickListener() {
        iv_toolbarMenu!!.setOnClickListener(this)
        iv_add_view_to_dashboard.setOnClickListener(this)
        iv_add_view.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()
        var mFragment: Fragment? = null
        mFragment = DashboardFragment()
        replaceFragment(mFragment)
    }


    override fun onClick(v: View?) {
        when (v!!.id) {

            R.id.iv_toolbarMenu -> {
                openOrCloseDrawerLayout()
            }

            R.id.iv_toolbarBack -> {
                handleBackPress()
            }

            R.id.iv_add_view_to_dashboard -> {
//                var mFragment: Fragment? = null
//                mFragment = AddWidgetsFragment()
//                replaceFragment(mFragment)
            }

            R.id.iv_add_view -> {

            }

        }

    }

    private fun openOrCloseDrawerLayout() {
        if (mDrawerLayout!!.isDrawerOpen(Gravity.LEFT)) {
            mDrawerLayout!!.closeDrawers()
        } else {
            mDrawerLayout!!.openDrawer(Gravity.LEFT)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_job_list -> setDisplayFragment(1)
            R.id.nav_calendar -> setDisplayFragment(2)
            R.id.nav_customers -> setDisplayFragment(3)
            R.id.nav_jobs -> setDisplayFragment(4)
            R.id.nav_inventory -> setDisplayFragment(5)
            R.id.nav_workers -> setDisplayFragment(6)
            R.id.nav_payroll -> setDisplayFragment(7)
            R.id.nav_approvals -> setDisplayFragment(8)
            R.id.nav_master_setup -> setDisplayFragment(9)
            R.id.nav_help -> setDisplayFragment(10)
        }

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    fun setDisplayFragment(id: Int) {
        var mFragment: Fragment? = null
        when (id) {
            1 -> {
                mFragment = JobListFragment()
                replaceFragment(mFragment)
            }
            2 -> {

            }
            3 -> {

            }
            4 -> {

            }
            5 -> {

            }
            6 -> {

            }
            7 -> {

            }
            8 -> {

            }
            9 -> {

            }
            10 -> {

            }

        }
    }


    fun setToolbarTitleText() {

    }


    fun setToolbarBackVisibility(isVisible: Boolean) {
        if (isVisible) {
            iv_toolbarBack!!.setVisibility(View.VISIBLE)
        } else {
            iv_toolbarBack!!.setVisibility(View.GONE)
        }
    }

    fun setToolbarAddWidgetVisibility(isVisible: Boolean) {
        if (isVisible) {
            iv_add_view!!.setVisibility(View.VISIBLE)
        } else {
            iv_add_view!!.setVisibility(View.GONE)
        }
    }


    fun handleBackPress() {
        if (mManager!!.findFragmentById(R.id.container) is DashboardFragment) {
            finish()
            //mManager!!.popBackStackImmediate()
        } else if (mManager!!.findFragmentById(R.id.container) is JobListFragment) {
            toolbar!!.visibility = View.VISIBLE
            mManager!!.popBackStackImmediate()
        } else if (mManager!!.findFragmentById(R.id.container) is AddWidgetsFragment) {
            // mManager!!.popBackStackImmediate()
        } else {
            mManager!!.popBackStackImmediate()
        }
    }


    override fun onBackPressed() {
        if (mDrawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout!!.closeDrawer(GravityCompat.START)
        } else {
            handleBackPress()
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        mManager = supportFragmentManager
        mTransaction = mManager!!.beginTransaction()
        mTransaction!!.replace(R.id.container, fragment)
        mTransaction!!.addToBackStack(null)
        mTransaction!!.commit()
    }


}