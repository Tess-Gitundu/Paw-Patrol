//package com.example.gitundu.adapters;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentPagerAdapter;
//
//import com.example.gitundu.CreateAccountFragment;
//import com.example.gitundu.LogInFragment;
//
//public class LoginAdapter extends FragmentPagerAdapter {
//
//    int totalTabs;
//
//    public LoginAdapter(FragmentManager fm, int totalTabs) {
//        super(fm);
//        this.totalTabs = totalTabs;
//    }
//
//    @NonNull
//    @Override
//    public Fragment getItem(int position) {
//        switch (position) {
//            case 0:
//                return new LogInFragment();
//            case 1:
//                return new CreateAccountFragment();
//            default:
//                return null;
//        }
//    }
//
//    @Override
//    public int getCount() {
//        return totalTabs;
//    }
//}
