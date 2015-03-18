package com.akturk.maskedwatcher;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.akturk.library.edittext.MaskedEditText;


public class HomeActivity extends ActionBarActivity {

    private static final String MASK = "(9A)";
    private MaskedEditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
    }

    @Override
    public void onSupportContentChanged() {
        super.onSupportContentChanged();

        mEditText = (MaskedEditText) findViewById(R.id.activity_home_edittext);

        MaskedEditText maskedEditText = new MaskedEditText(this);
        maskedEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        maskedEditText.setCharRepresentation('c');
        maskedEditText.setMask("ccc.ccc.ccc-cc");

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.activity_home_layout);
        linearLayout.addView(maskedEditText);
    }
}
