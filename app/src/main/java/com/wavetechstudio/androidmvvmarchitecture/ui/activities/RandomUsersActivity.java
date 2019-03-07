package com.wavetechstudio.androidmvvmarchitecture.ui.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wavetechstudio.androidmvvmarchitecture.R;
import com.wavetechstudio.androidmvvmarchitecture.ui.fragments.RandomUsersFragment;
import com.wavetechstudio.androidmvvmarchitecture.ui.fragments.dummy.DummyContent;

import javax.inject.Inject;

import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class RandomUsersActivity extends AppCompatActivity implements HasSupportFragmentInjector, RandomUsersFragment.OnListFragmentInteractionListener {


    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;


    @Override
    public DispatchingAndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        AndroidInjection.inject(this);


        RandomUsersFragment randomUsersFragment = RandomUsersFragment.newInstance(1);
        getSupportFragmentManager().beginTransaction().add(R.id.framelayout_activity_randomusers,
                randomUsersFragment, RandomUsersFragment.TAG).commit();
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this, item.details, Toast.LENGTH_LONG).show();
    }

}
