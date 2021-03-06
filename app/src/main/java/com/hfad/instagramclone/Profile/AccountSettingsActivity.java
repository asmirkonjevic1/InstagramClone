package com.hfad.instagramclone.Profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.hfad.instagramclone.R;
import com.hfad.instagramclone.Utils.SectionsStatePagerAdapter;

import java.util.ArrayList;

public class AccountSettingsActivity extends AppCompatActivity {

    private static final String TAG = "AccountSettingsActivity";
    private SectionsStatePagerAdapter pagerAdapter;
    private ViewPager mViewPager;
    private RelativeLayout mRelativeLayout;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountsettings);
        Log.d(TAG, "onCreate: Started");
        mViewPager = findViewById(R.id.container);
        mRelativeLayout = findViewById(R.id.relLayout1);

        setupSettingsList();

        setupFragments();
        //setup the backarrow to navige to ProfileActivity
        setupBackArrow();

    }

    private void setupFragments(){
        pagerAdapter = new SectionsStatePagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new EditProfileFragment(), getString(R.string.edit_profile));
        pagerAdapter.addFragment(new SignOutFragment(), getString(R.string.sign_out));
    }

    private void setupSettingsList(){
        Log.d(TAG, "setupSettingsList: initializing Account Settings List");
        ListView listView = findViewById(R.id.lvAccountSettings);

        ArrayList<String> options = new ArrayList<>();
        options.add(getString(R.string.edit_profile));
        options.add(getString(R.string.sign_out));

        ArrayAdapter adapter = new ArrayAdapter(AccountSettingsActivity.this, android.R.layout.simple_list_item_1, options);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: navigating to fragment " + position);
                setViewPager(position);
            }
        });
    }

    private void setViewPager(int fragmentNumber){
        mRelativeLayout.setVisibility(View.GONE);
        Log.d(TAG, "setViewPager: navigating to fragment number " + fragmentNumber);
        mViewPager.setAdapter(pagerAdapter);
        mViewPager.setCurrentItem(fragmentNumber);
    }

    private void setupBackArrow() {
        ImageView backArrow = findViewById(R.id.backArrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Navigating back to ProfileActivity");
                finish();
            }
        });
    }
}
