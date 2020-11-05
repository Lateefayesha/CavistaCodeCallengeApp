package com.appynitty.cavistacodecallengeapp

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.appynitty.cavistacodecallengeapp.home.model.HomeModel
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {

val navController=null;
    override fun onCreate(savedInstanceState: Bundle?) {
//        private const var TAG = "MainActivity"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))






    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in
        // AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun callNextFragment(o: HomeModel) {
        var bundle = bundleOf(getString(R.string.argument_home_model )to o)
        Log.d("CallNextFragment", "callNextFragment: "+Gson().toJson(o))
        findNavController(R.id.nav_host_fragment).navigate(R.id.imageDetailsFragment,bundle)
    }
}