package com.example.johnnieexample;



import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private Drawable mBarIcon;
    ImageView home,black,red , blue;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        home= (ImageView)findViewById(R.id.home_background);
        black= (ImageView)findViewById(R.id.black);
        red= (ImageView)findViewById(R.id.red);
        blue= (ImageView)findViewById(R.id.blue);
        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    

	public void onSectionAttached(int number) {
		 Animation sunRise = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
		 Animation fadeout = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        switch (number) {
            case 1:
                mBarIcon=getResources().getDrawable(R.drawable.ic_home);
                home.setVisibility(View.VISIBLE);
                home.startAnimation(sunRise);

	            if(mTitle.toString().contentEquals("Red")){
	            	 mTitle = getString(R.string.title_section1);
	         		//apply the animation to the View
	                 red.startAnimation(fadeout);
	            }else if(mTitle.toString().contentEquals("Black")){
	            	 mTitle = getString(R.string.title_section1);
	         		//apply the animation to the View
	                 black.startAnimation(fadeout);
	            }else if(mTitle.toString().contentEquals("Blue")){
	            	 mTitle = getString(R.string.title_section1);
	         		//apply the animation to the View
	                 blue.startAnimation(fadeout);
	            }else{
	            	 mTitle = getString(R.string.title_section1);
	            }
               
                break;
            case 2:
                black.startAnimation(sunRise);
                black.setVisibility(View.VISIBLE);

            	 if(mTitle.toString().contentEquals("Red")){
                	 mTitle = getString(R.string.title_section2);
             		//apply the animation to the View
                     red.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Home")){
                	 mTitle = getString(R.string.title_section2);
             		//apply the animation to the View
                     home.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Blue")){
                	 mTitle = getString(R.string.title_section2);
             		//apply the animation to the View
                     blue.startAnimation(fadeout);
                }else{
	            	 mTitle = getString(R.string.title_section2);
	            }
                break;//Black
            case 3:
                red.startAnimation(sunRise);
                red.setVisibility(View.VISIBLE);

            	 if(mTitle.toString().contentEquals("Home")){
                	 mTitle = getString(R.string.title_section3);
             		//apply the animation to the View
                     home.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Black")){
                	 mTitle = getString(R.string.title_section3);
             		//apply the animation to the View
                     black.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Blue")){
                	 mTitle = getString(R.string.title_section3);
             		//apply the animation to the View
                     blue.startAnimation(fadeout);
                }else{
	            	 mTitle = getString(R.string.title_section3);
	            }

                break;//Red
            case 4:
            	blue.startAnimation(sunRise);
            	blue.setVisibility(View.VISIBLE);

            	 mBarIcon=getResources().getDrawable(R.drawable.ic_home);
            	 if(mTitle.toString().contentEquals("Red")){
                	 mTitle = getString(R.string.title_section4);
             		//apply the animation to the View
                     red.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Black")){
                	 mTitle = getString(R.string.title_section4);
             		//apply the animation to the View
                     black.startAnimation(fadeout);
                }else if(mTitle.toString().contentEquals("Home")){
                	 mTitle = getString(R.string.title_section4);
             		//apply the animation to the View
                     home.startAnimation(fadeout);
                }else{
	            	 mTitle = getString(R.string.title_section4);
	            }

            	break;//blue
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
        actionBar.setIcon(mBarIcon);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
        	
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
