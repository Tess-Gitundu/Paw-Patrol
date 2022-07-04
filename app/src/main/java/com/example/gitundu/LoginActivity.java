package com.example.gitundu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.gitundu.adapters.LoginAdapter;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.register) TextView mRegisterAccount;

//    @BindView(R.id.tabLayout) TabLayout mTabLayout;
//    @BindView(R.id.view_pager) ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mRegisterAccount.setOnClickListener(this);


//        TabLayout.Tab firstTab = mTabLayout.newTab();
//        firstTab.setText("Log In");
//        mTabLayout.addTab(firstTab);
//
//        TabLayout.Tab secondTab = mTabLayout.newTab();
//        secondTab.setText("Create Account");
//        mTabLayout.addTab(secondTab);
//
//        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
//
//        LoginAdapter adapter = new LoginAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
//        mViewPager.setAdapter(adapter);
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
//
//        mTabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
//
//
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                mViewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        if (view == mRegisterAccount) {
            Intent intent = new Intent(LoginActivity.this, CreateAccountActivity.class);
            startActivity(intent);
            finish();
        }
    }
}