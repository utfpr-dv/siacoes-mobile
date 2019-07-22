package br.edu.utfpr.dv.siacoes.mobile.activity

import android.app.ActivityOptions
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import androidx.viewpager.widget.ViewPager
import br.edu.utfpr.dv.siacoes.mobile.R
import br.edu.utfpr.dv.siacoes.mobile.Session
import br.edu.utfpr.dv.siacoes.mobile.client.UserClient
import br.edu.utfpr.dv.siacoes.mobile.model.User
import br.edu.utfpr.dv.siacoes.mobile.model.UserDepartment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

abstract class BaseActivity(val subtitle : String?, val hideMenu : Boolean, val useTabs : Boolean, val useBottomMenu : Boolean, val bottomMenuResource : Int?) : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        if(!hideMenu) {
            val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
            val navView: NavigationView = findViewById(R.id.nav_view)
            val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            navView.setNavigationItemSelectedListener(this)
        } else {
            findViewById<DrawerLayout>(R.id.drawer_layout).setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }

        if(useTabs) {
            findViewById<TabLayout>(R.id.tabs).visibility = View.VISIBLE
            findViewById<ViewPager>(R.id.view_pager).visibility = View.VISIBLE
        } else {
            findViewById<TabLayout>(R.id.tabs).visibility = View.GONE
            findViewById<ViewPager>(R.id.view_pager).visibility = View.GONE
        }

        val bottomMenu: BottomNavigationView = findViewById(R.id.bottom_nav_view)
        if(useBottomMenu) {
            bottomMenu.menu.clear()
            bottomMenu.inflateMenu(bottomMenuResource!!)
            bottomMenu.setOnNavigationItemSelectedListener { item ->
                return@setOnNavigationItemSelectedListener this.onNavigationItemSelected(item)
            }
        } else {
            bottomMenu.visibility = View.GONE
        }

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        if(subtitle != null) {
            supportActionBar?.subtitle = subtitle
        }

        this.showLoading()

        if(Session().getUserInfo() == null) {
            UserClient().profile({
                Session().setUserInfo(it)
                configureMenu()
            }, {
                //Toast.makeText(this, "Falha ao buscar as notas", Toast.LENGTH_LONG).show()
            })
        } else {
            configureMenu()
        }
    }

    override fun setContentView(layoutResID: Int) {
        var drawerLayout: DrawerLayout = layoutInflater.inflate(R.layout.activity_base, null) as DrawerLayout
        var activityContainer: FrameLayout = drawerLayout.findViewById(R.id.layout_container)
        layoutInflater.inflate(layoutResID, activityContainer, true)

        super.setContentView(drawerLayout)
    }

    fun showLoading() {
        findViewById<ProgressBar>(R.id.loading).visibility = View.VISIBLE
    }

    fun hideLoading() {
        findViewById<ProgressBar>(R.id.loading).visibility = View.GONE
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //return when (item.itemId) {
            //R.id.action_settings -> true
            //else ->
        return super.onOptionsItemSelected(item)
        //}
    }

    protected open fun onBottomMenuItemSelected(item : MenuItem) : Boolean {
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_sigac -> {
                val intent = Intent(this, ActivitySubmissionActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_siges -> {
                val intent = Intent(this, InternshipActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_siget -> {
                val intent = Intent(this, SigetActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_jury -> {
                val intent = Intent(this, AttendedJuryActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_calendar -> {
                val intent = Intent(this, CalendarActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle())
            }
            R.id.nav_logoff -> {
                val PREFS_FILENAME = "br.edu.utfpr.dv.siacoes.prefs"
                val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
                val prefs = EncryptedSharedPreferences.create(
                    PREFS_FILENAME,
                    masterKeyAlias,
                    this,
                    EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                    EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
                )

                val editor = prefs.edit()
                editor.remove("login")
                editor.remove("password")
                editor.apply()

                val intent = Intent(this, LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                ActivityCompat.finishAffinity(this)
            }
            else -> {
                return onBottomMenuItemSelected(item)
            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun configureMenu() {
        val navView: NavigationView = findViewById(R.id.nav_view)

        navView.getHeaderView(0).findViewById<TextView>(R.id.navUserName)?.text = Session().getUserInfo()?.name
        navView.getHeaderView(0).findViewById<TextView>(R.id.navUserEmail)?.text = Session().getUserInfo()?.email

        if (Session().getUserInfo()?.photo != null) {
            navView.getHeaderView(0).findViewById<ImageView>(R.id.navUserPhoto)?.setImageBitmap(BitmapFactory.decodeByteArray(Session().getUserInfo()?.photo, 0, Session().getUserInfo()?.photo?.size!!))
        }

        this.hideLoading()
        this.configureProfile()
    }

    private fun configureProfile() {
        if(Session().getProfile() == null) {
            UserClient().listProfiles({
                val profiles : List<User.UserProfile> = it

                for(p in profiles) {
                    if(p == User.UserProfile.STUDENT) {
                        Session().setProfile(p)
                    }
                }

                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserProfile)?.text = Session().getProfile().toString()
                this.configureDepartment()
            }, {
                Session().setProfile(User.UserProfile.STUDENT)
                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserProfile)?.text = Session().getProfile().toString()
                this.configureDepartment()
            })
        } else {
            findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserProfile)?.text = Session().getProfile().toString()
            this.configureDepartment()
        }
    }

    private fun configureDepartment() {
        if(Session().getUserDepartment() == null) {
            UserClient().listDepartments(Session().getProfile()?.value!!, {
                val departments : List<UserDepartment> = it

                if(departments.isNotEmpty()) {
                    Session().setUserDepartment(departments[0])
                }

                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserDepartment)?.text = Session().getDepartmentName()
                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserCampus)?.text = Session().getCampusName()
            }, {
                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserDepartment)?.text = Session().getDepartmentName()
                findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserCampus)?.text = Session().getCampusName()
            })
        } else {
            findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserDepartment)?.text = Session().getDepartmentName()
            findViewById<NavigationView>(R.id.nav_view).getHeaderView(0).findViewById<TextView>(R.id.navUserCampus)?.text = Session().getCampusName()
        }
    }

}
