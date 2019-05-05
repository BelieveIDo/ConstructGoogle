package com.example.constructdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.constructdemo.R
import com.example.constructdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bindingUtil: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingUtil=DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawerLayout=bindingUtil.drawerLayout
        navController=Navigation.findNavController(this,R.id.garden_nav_fragment)
        appBarConfiguration= AppBarConfiguration(navController.graph,drawerLayout)
        setSupportActionBar(bindingUtil.toolbar)
        setupActionBarWithNavController(navController,appBarConfiguration)
        bindingUtil.navigationView.setupWithNavController(navController)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed()

        }
    }

    //可以使用后退的按钮使用 按照任务栈顶的元素出栈
    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp(appBarConfiguration)
    }

}