package com.example.gitundu;

import static org.junit.Assert.assertTrue;

import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.w3c.dom.Text;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateTextViewContent() {
        TextView headerTextView = activity.findViewById(R.id.headerTextView);
        assertTrue("Paw Patrol".equals(headerTextView.getText().toString()));
    }
}
