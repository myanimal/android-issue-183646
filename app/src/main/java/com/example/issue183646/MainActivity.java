package com.example.issue183646;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new TestFragment()).commit();
    }

    private static void showFragment(FragmentManager fm) {
        fm.beginTransaction()
                .replace(R.id.container, new TestFragment())
                .addToBackStack(null).commit();
    }

    public static class TestFragment extends Fragment {
        public TestFragment() {}
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment, container, false);
            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showFragment(getFragmentManager());
                }
            });
            return view;
        }
    }
}
