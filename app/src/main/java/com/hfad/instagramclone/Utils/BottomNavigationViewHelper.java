package com.hfad.instagramclone.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.hfad.instagramclone.AddPhoto.AddPhotoActivity;
import com.hfad.instagramclone.Friends.FriendsActivity;
import com.hfad.instagramclone.Home.MainActivity;
import com.hfad.instagramclone.Likes.LikesActivity;
import com.hfad.instagramclone.Profile.ProfileActivity;
import com.hfad.instagramclone.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx){
        Log.d(TAG, "setting bottom navigation view");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.ic_home:
                        Intent homeIntent = new Intent(context, MainActivity.class);
                        context.startActivity(homeIntent);
                        break;

                    case R.id.ic_addphoto:
                        Intent addPhotoIntent = new Intent(context, AddPhotoActivity.class);
                        context.startActivity(addPhotoIntent);
                        break;

                    case R.id.ic_friends:
                        Intent friendsIntent = new Intent(context, FriendsActivity.class);
                        context.startActivity(friendsIntent);
                        break;

                    case R.id.ic_likes:
                        Intent likesIntent = new Intent(context, LikesActivity.class);
                        context.startActivity(likesIntent);
                        break;

                    case R.id.ic_profile:
                        Intent profileIntent = new Intent(context, ProfileActivity.class);
                        context.startActivity(profileIntent);
                        break;
                }

                return false;
            }
        });
    }

}
