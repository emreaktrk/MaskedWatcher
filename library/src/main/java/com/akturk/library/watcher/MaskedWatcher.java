package com.akturk.library.watcher;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class MaskedWatcher implements TextWatcher {

    private static final char sNUMERIC_REP = '9';
    private static final char sALPHABETIC_REP = 'A';

    private CharSequence mMask;
    private EditText mEditText;
    private boolean isUpdating;

    public MaskedWatcher(EditText editText, String mask) {
        if (mask == null)
            throw new RuntimeException("Mask can't be null");

        if (editText == null)
            throw new RuntimeException("EditText can't be null");

        mEditText = editText;
        mMask = mask;

        mEditText.addTextChangedListener(this);
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (isUpdating) {
            isUpdating = false;
            return;
        }

        if (s.length() > mMask.length()) {
            delete();
            return;
        }

        int position = start - before;
        char insertedChar = s.charAt(position);
        char maskedChar = mMask.charAt(position);

        if (maskedChar != sALPHABETIC_REP && maskedChar != sNUMERIC_REP)
            insert(position, maskedChar);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private void delete() {
        isUpdating = true;

        int start = 0;
        int end = mEditText.getText().length();

        CharSequence charSequence = mEditText.getText().subSequence(start, end);
        mEditText.setText(charSequence);
    }

    private void insert(int position, char mask) {
        isUpdating = true;

        mEditText.getText().insert(position, mask + "");
    }


}